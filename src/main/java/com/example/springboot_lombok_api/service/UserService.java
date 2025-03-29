package com.example.springboot_lombok_api.service;

import com.example.springboot_lombok_api.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User createUser (User user);
    List<User> getAllUsers();
    Optional<User> getUserById(Long id);
}
