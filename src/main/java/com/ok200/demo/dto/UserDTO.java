package com.ok200.demo.dto;


import java.util.Set;
import lombok.Data;

@Data
public class UserDTO {

    private String username;
    private String description;
    private String discordLink;
    private Set<String> technologies;

}
