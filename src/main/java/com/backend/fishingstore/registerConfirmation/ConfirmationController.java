package com.backend.fishingstore.registerConfirmation;

import com.backend.fishingstore.model.ConfirmationToken;
import com.backend.fishingstore.model.User;
import com.backend.fishingstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;

@Controller
public class ConfirmationController {

    @Autowired
    ConfirmationTokenService confirmationTokenService;
    @Autowired
    UserService userService;

    @GetMapping("/user-confirmation")
    public ResponseEntity<?> registerConfirmation(@RequestParam("token") String token) {
        // Step 1: Fetch the confirmation token
        ConfirmationToken confirmationToken = confirmationTokenService.findByToken(token)
                .orElse(null);

        // Step 2: Check if token is null (not found)
        if (confirmationToken == null) {
            return ResponseEntity.badRequest().body("Invalid token");
        }

        // Step 3: Check if the token has expired
        if (confirmationToken.getExpirationDate().isBefore(LocalDateTime.now())) {
            return ResponseEntity.badRequest().body("Token has expired");
        }


        User user = confirmationToken.getUser();
        //Step 4 verificare daca useru e confirmat deja
        if(user.getIsVerified()==true) {
            return ResponseEntity.badRequest().body("User is already verified");
        }

        // Step 5: Confirm the token
        user.setIsVerified(true);
        userService.saveUser(user); // Assuming you have a method to save the user

        // Optional: Update confirmation date in the token
        confirmationToken.setConfirmationDate(LocalDateTime.now());
        confirmationTokenService.saveConfirmationToken(confirmationToken);

        return ResponseEntity.ok().body("Account has been successfully confirmed");
    }


}
