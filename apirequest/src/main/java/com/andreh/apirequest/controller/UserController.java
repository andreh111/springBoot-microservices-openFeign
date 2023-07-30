package com.andreh.apirequest.controller;


import com.andreh.apirequest.exception.CustomInternalServerException;
import com.andreh.apirequest.exception.CustomNotFoundException;
import com.andreh.apirequest.models.User;
import com.andreh.apirequest.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User u = userService.getUserById(id);
        if (u == null) {
            throw new CustomNotFoundException("User not found with the id " + id);
        }

        return ResponseEntity.ok(u);
    }

    @GetMapping("")
    public ResponseEntity<List<User>> getAllUsers() {
        try {
            List<User> users = userService.getAllUsers();
            return ResponseEntity.ok(users);
        } catch (Exception ex) {
            throw new CustomInternalServerException("An internal server error occurred while fetching users.");
        }
    }
}
