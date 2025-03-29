package com.example.springboot_lombok_api.service;

import com.example.springboot_lombok_api.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl  implements  UserService{

    public List<User> users = new ArrayList<>();

    @Override
    public User createUser(User user) {
        users.add(user);
        return  user;
    }

    @Override
    public List<User> getAllUsers() {
        return users;
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return users.stream().filter(user -> user.getId().equals(id)).findFirst();
    }
}
