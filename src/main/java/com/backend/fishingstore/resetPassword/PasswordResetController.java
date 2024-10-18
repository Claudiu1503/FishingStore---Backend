package com.backend.fishingstore.resetPassword;

import com.backend.fishingstore.model.PasswordResetToken;
import com.backend.fishingstore.model.User;
import com.backend.fishingstore.service.UserService;
import org.antlr.v4.runtime.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;

@Controller
public class PasswordResetController {


    @Autowired
    PasswordResetService passwordResetService;

    @Autowired
    UserService userService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @PostMapping("/validate-resetpassword")
    public ResponseEntity<?> resetPasswordConfirmationToken(@RequestParam("passwordToken") String token


                                                       ) {
        // Găsește token-ul
        PasswordResetToken passwordResetToken = passwordResetService.findPasswordResetToken(token)
                .orElse(null);
        if(passwordResetToken == null) {
            return ResponseEntity.badRequest().body("Invalid token");
        }

        // Verifică expirarea token-ului
        if(passwordResetToken.getExpirationDate().isBefore(LocalDateTime.now())) {
            return ResponseEntity.badRequest().body("Expired token");
        }


        // Găsește utilizatorul asociat cu token-ul
        User user = passwordResetToken.getUser();
        if (user == null) {
            return ResponseEntity.badRequest().body("User not found");
        }
        //validam tokenul
        passwordResetService.setPasswordResetTokenIsVerified(passwordResetToken);

        // Redirecționează utilizatorul către pagina de confirmare ("/confirm-new-password")
        return ResponseEntity.status(HttpStatus.OK).body("Redirecting for changing password");
    }
    @PostMapping("/confirm-new-password")
    public ResponseEntity<?> resetPasswordConfirmationFinal(@RequestParam("passwordToken") String token,
                                                            @RequestBody String newPassword) {

        PasswordResetToken passwordResetToken = passwordResetService.findPasswordResetToken(token)
                .orElse(null);
        if(passwordResetToken == null) {
            return ResponseEntity.badRequest().body("Invalid token");
        }

        User user = passwordResetToken.getUser();
        if (user == null) {
            return ResponseEntity.badRequest().body("User not found");
        }


        if(passwordResetToken.getIsVerified()==true){

            try {
                User newUser = userService.updateUserPassword(user.getId(),newPassword);
                return ResponseEntity.ok(newUser);
            } catch (IllegalStateException e) {

                return ResponseEntity.badRequest().body("Eroare in passwordResetController");
            }
        }
        else
            return ResponseEntity.badRequest().body("Tokenul de activare nu a fost activat din adresa de email");
    }


}
