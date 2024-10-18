package com.backend.fishingstore.DTO;

public class ResetPasswordRequestDTO {
    private String email;
    // Constructor, getter și setter
    public ResetPasswordRequestDTO() {}

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

