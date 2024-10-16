package com.backend.fishingstore.registerConfirmation;

import com.backend.fishingstore.model.User;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity

public class ConfirmationToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String token;

    @Column(nullable = false)
    private LocalDateTime creationDate;

    @Column(nullable = false)
    private LocalDateTime expirationDate;

    private LocalDateTime confirmationDate;

    @ManyToOne
    @JoinColumn(nullable = false, name = "user_id")
    private User user;

    public ConfirmationToken(String token, LocalDateTime creationDate, LocalDateTime expirationDate, LocalDateTime confirmationDate, User user) {
        this.token = token;
        this.creationDate = creationDate;
        this.expirationDate = expirationDate;
        this.confirmationDate = confirmationDate;
        this.user = user;
    }
}
