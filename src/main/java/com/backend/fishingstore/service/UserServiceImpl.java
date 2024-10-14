package com.backend.fishingstore.service;

import com.backend.fishingstore.model.User;
import com.backend.fishingstore.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService  {

    @Autowired
    UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public User register(User user) {
        // Verificăm dacă email-ul este deja înregistrat
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new IllegalStateException("Email already taken");
        }

        // Criptăm parola
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setCreatedAt(LocalDateTime.now());
        user.setIsVerified(false); // Inițial nu este verificat

        return userRepository.save(user);
    }

    public String login(String email, String password) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("Invalid email"));

        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new IllegalArgumentException("Invalid password");
        }

        return "Logged in successfully";
    }

    @Override
    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }

    @Override
    public User updateUser(int id, User updatedUser) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        if(updatedUser.getEmail()!=null) {
            user.setEmail(updatedUser.getEmail());
        }
        if(updatedUser.getIsVerified()!=null) {
            user.setIsVerified(updatedUser.getIsVerified());
        }
        if (updatedUser.getName() != null) {
            user.setName(updatedUser.getName());
        }
        if (updatedUser.getLocation() != null) {
            user.setLocation(updatedUser.getLocation());
        }
        if (updatedUser.getRole() != null) {
            user.setRole(updatedUser.getRole());
        }
        if (updatedUser.getPassword() != null) {
            user.setPassword(updatedUser.getPassword());
            user.setPassword(passwordEncoder.encode(updatedUser.getPassword()));
        }

        user.setUpdatedAt(LocalDateTime.now());

        return userRepository.save(user);
    }


    @Override
    public String getUserProfile(int id) {
        return userRepository.findById(id).toString();
    }

    @Override
    public List<User> listAllUsers() {
        return userRepository.findAll();
    }


}
