package com.ok200.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ok200.demo.dto.UserDTO;
import com.ok200.demo.mapper.UserMapper;
import com.ok200.demo.model.User;
import com.ok200.demo.service.UserService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("api/v1/users")
public class UserController {

    private UserService userService;
    private UserMapper userMapper;
    public UserController(UserService userService, UserMapper userMapper) {
    this.userService = userService;
    this.userMapper = userMapper;

  }

    @PostMapping
    public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
        return userService.createUser(user);
    }
    

    @GetMapping("/{id}/matches")
public ResponseEntity<List<UserDTO>> getMatches(@PathVariable("id") Integer userId) {
    List<User> matchesdUsers = userService.getMatchesByUserId(userId);
    List<UserDTO> dtos = matchesdUsers.stream()
                                      .map(userMapper::toDTO)
                                      .toList();
    return ResponseEntity.ok(dtos);
}




}
