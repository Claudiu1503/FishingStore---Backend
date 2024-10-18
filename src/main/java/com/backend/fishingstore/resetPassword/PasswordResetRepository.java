package com.backend.fishingstore.resetPassword;

import com.backend.fishingstore.model.PasswordResetToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PasswordResetRepository extends JpaRepository<PasswordResetToken,Integer> {
    Optional<PasswordResetToken> findByPasswordToken(String token);

}
