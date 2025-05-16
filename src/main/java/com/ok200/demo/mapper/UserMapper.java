package com.ok200.demo.mapper;

import org.springframework.stereotype.Component;

import com.ok200.demo.dto.UserDTO;
import com.ok200.demo.model.User;

@Component
public class UserMapper {

    public UserDTO toDTO (User user) {
        UserDTO dto = new UserDTO();
        dto.setUsername(user.getUsername());
        dto.setDescription(user.getDescription());
        dto.setDiscordLink(user.getDiscordLink());
        return dto;
    }

    public User toEntity (UserDTO dto) {
        User user = new User ();
        user.setUsername(dto.getUsername());
        user.setDescription(dto.getDescription());
        user.setDiscordLink(dto.getDiscordLink());
        return user;

    }
}
