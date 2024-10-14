package com.backend.fishingstore.service;

import com.backend.fishingstore.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {

    String getUserProfile(int id);
    List<User> listAllUsers();
    User register(User user);
    String login(String email, String password);

    void deleteUser(int id);

    User updateUser(int id, User updatedUser);


}
