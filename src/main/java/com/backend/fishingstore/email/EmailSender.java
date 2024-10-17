package com.backend.fishingstore.email;

public interface EmailSender {
    void send(String to, String email);
}
