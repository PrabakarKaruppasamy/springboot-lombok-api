package com.example.springboot_lombok_api.controller;


import com.example.springboot_lombok_api.exception.UserNotFoundException;
import com.example.springboot_lombok_api.model.User;
import com.example.springboot_lombok_api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController

@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService)
    {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers()
    {
        List<User> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user)
    {
        User createdUser = userService.createUser(user);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id)
    {
        Optional<User> user = userService.getUserById(id);
        if(user.isPresent())
        {
            return new ResponseEntity<>(user.get(), HttpStatus.OK);
        }else {
            throw new UserNotFoundException("User not found with id..."+id);
        }
    }
}
