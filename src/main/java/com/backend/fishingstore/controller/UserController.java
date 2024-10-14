package com.backend.fishingstore.controller;


import com.backend.fishingstore.model.User;
import com.backend.fishingstore.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    UserService userService;

  @GetMapping("/view-profile/{}")
  public String getUserProfile(@PathVariable int id) {
      return userService.getUserProfile(id);
  }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@Valid @RequestBody User user) {

        return ResponseEntity.ok("User registered successfully!");
    }
}
