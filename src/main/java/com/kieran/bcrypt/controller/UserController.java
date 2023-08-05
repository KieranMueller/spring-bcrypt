package com.kieran.bcrypt.controller;

import com.kieran.bcrypt.entity.User;
import com.kieran.bcrypt.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<User> getAll() {
        return userService.getAll();
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @PostMapping("login")
    public String login(@RequestBody User user) {
        return userService.login(user);
    }
}
