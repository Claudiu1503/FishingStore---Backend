package com.backend.fishingstore.service;

import com.backend.fishingstore.DTO.ResetPasswordRequestDTO;
import com.backend.fishingstore.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface UserService {

    String getUserProfileString(int id);
    List<User> listAllUsers();
    User register(User user);
    String login(String email, String password);

    void deleteUser(int id);

    User updateUser(int id, User updatedUser);


    void saveUser(User user);

    User findUserById(int id);

    Optional<User> findUserByEmail(String email);
    public User updateUserPassword(int id, String newPassword);
    void mailSendResetPassowrd(ResetPasswordRequestDTO emailDTO);
}
