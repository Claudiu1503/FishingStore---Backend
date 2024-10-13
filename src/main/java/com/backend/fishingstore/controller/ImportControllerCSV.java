package com.backend.fishingstore.controller;

import com.backend.fishingstore.service.UserService;
import com.backend.fishingstore.service.UserServiceCSV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ImportControllerCSV {

    @Autowired
    private UserServiceCSV importUsersFromCSV;

    @GetMapping("/import-users")
    public String importUsers() {
        importUsersFromCSV.importUsersFromCSV();
        return "Users imported successfully!";
    }
}
