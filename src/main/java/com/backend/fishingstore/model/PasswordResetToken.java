package com.backend.fishingstore.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
public class PasswordResetToken {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String passwordToken;

    @Column(nullable = false)
    private LocalDateTime creationDate;

    @Column(nullable = false)
    private LocalDateTime expirationDate;

    private Boolean isVerified;
    private Boolean passChanged;

    @ManyToOne
    @JoinColumn(nullable = false, name = "user_id")
    private User user;

    public PasswordResetToken(String passwordToken, LocalDateTime creationDate, LocalDateTime expirationDate, User user, Boolean isVerified, Boolean passChanged) {
        this.passwordToken = passwordToken;
        this.creationDate = creationDate;
        this.expirationDate = expirationDate;
        this.isVerified = isVerified;
        this.passChanged = passChanged;
        this.user = user;
    }
}
