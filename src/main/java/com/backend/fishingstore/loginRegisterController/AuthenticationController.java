package com.backend.fishingstore.loginRegisterController;
import com.backend.fishingstore.DTO.ResetPasswordRequestDTO;
import com.backend.fishingstore.model.PasswordResetToken;
import com.backend.fishingstore.model.User;
import com.backend.fishingstore.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class AuthenticationController {

    @Autowired
    private UserService userService;

@PostMapping("/register")
public ResponseEntity<?> register(@RequestBody User user) {
    try {
        // Aici returnăm un ResponseEntity cu un obiect de tip User în caz de succes
        User newUser = userService.register(user);
        return ResponseEntity.ok(newUser); // Returnăm 200 OK și noul utilizator în răspuns
    } catch (IllegalStateException e) {
        if (e.getMessage().equals("Email already taken")) {
            // Returnăm un răspuns cu 409 Conflict dacă email-ul este deja folosit
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
        // Pentru alte tipuri de erori, returnăm 400 Bad Request
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestHeader("Authorization") String authHeader) {
        if (authHeader != null && authHeader.startsWith("Basic ")) {
            String base64Credentials = authHeader.substring("Basic ".length()).trim();
            String credentials = new String(Base64.getDecoder().decode(base64Credentials));
            final String[] values = credentials.split(":", 2);
            String email = values[0];
            String password = values[1];

//            Pentru debugging
//            System.out.println("Email: " + email + ", Password: " + password);

            try {
                String user = userService.login(email, password);
                return ResponseEntity.ok(user);
            } catch (IllegalArgumentException e) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
            }
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Authorization header is missing or invalid.");
    }


    //Metoda cu DTO
    @PostMapping("/reset-password-email-sender")
    public ResponseEntity<?> resetPassword(@RequestBody ResetPasswordRequestDTO resetPasswordRequest) {

        String email = resetPasswordRequest.getEmail();

        if (email == null || email.isBlank() || email.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Email is required.");
        }

//        System.out.println("Email primit pentru resetare parola: " + email);

        Optional<User> userOptional = userService.findUserByEmail(email);

        if (userOptional.isPresent()) {
            // Logic to send reset password email
            userService.mailSendResetPassowrd(resetPasswordRequest);
            return ResponseEntity.status(HttpStatus.OK).body("S-a trimis un email pentru resetarea parolei");
        } else {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Email-ul nu a fost găsit.");
        }
    }



}

