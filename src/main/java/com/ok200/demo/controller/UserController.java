package com.ok200.demo.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ok200.demo.model.User;
import com.ok200.demo.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("api/v1/users")
public class UserController {

    private UserService userService;
    // private UserMapper userMapper;
    public UserController(UserService userService) {
    this.userService = userService;

  }

    @PostMapping
    public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
        return userService.createUser(user);
    }
    



}
