package com.backend.fishingstore.controllerCSV;

import com.backend.fishingstore.serviceCSV.UserServiceCSV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
