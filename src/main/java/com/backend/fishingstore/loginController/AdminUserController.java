package com.backend.fishingstore.loginController;

import com.backend.fishingstore.model.User;
import com.backend.fishingstore.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminUserController {

    @Autowired
    private final UserService userService;

    // Vizualizează toți utilizatorii
    @GetMapping("/list-users")
    public List<User> listAllUsers() {
        return userService.listAllUsers();
    }

    // Șterge un utilizator
    @DeleteMapping("/delete-user/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
        return ResponseEntity.ok("User deleted successfully");
    }

    // Modifică un utilizator
    @PutMapping("/modify-user/{id}")
    public ResponseEntity<User> updateUser(@PathVariable int id, @RequestBody User updatedUser) {
        User user = userService.updateUser(id, updatedUser);
        return ResponseEntity.ok(user);
    }

}
