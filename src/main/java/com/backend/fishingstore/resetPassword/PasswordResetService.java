package com.backend.fishingstore.resetPassword;

import com.backend.fishingstore.model.PasswordResetToken;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class PasswordResetService {

    @Autowired
    private PasswordResetRepository passwordResetRepository;

    public void PasswordResetToken(PasswordResetToken passwordResetToken) {
        passwordResetRepository.save(passwordResetToken);
    }
    public Optional<PasswordResetToken> findPasswordResetToken(String token) {
      return passwordResetRepository.findByPasswordToken(token);
    }
    public void savePasswordResetToken(PasswordResetToken passwordResetToken) {
        passwordResetRepository.save(passwordResetToken);
    }
    public void setPasswordResetTokenIsVerified(PasswordResetToken passwordResetToken) {
        passwordResetToken.setIsVerified(true);
       passwordResetRepository.save(passwordResetToken);

    }
    public void setPasswordResetTokenpassChanged(PasswordResetToken passwordResetToken) {
        passwordResetToken.setPassChanged(true);
        passwordResetRepository.save(passwordResetToken);

    }

}
