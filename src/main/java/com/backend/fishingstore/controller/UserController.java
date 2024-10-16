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


    //Numa daca e a lui id-ul!!!!
//  @GetMapping("/view-profile/{}")
//  public String getUserProfileString(@PathVariable int id) {
//      return userService.getUserProfile(id);
//  }

}
