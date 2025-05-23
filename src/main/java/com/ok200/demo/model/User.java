package com.ok200.demo.model;

import java.util.HashSet;
import java.util.Set;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import jakarta.validation.constraints.Pattern;


@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @SequenceGenerator (name = "user_id_sequense", sequenceName = "user_id_sequense", allocationSize = 1, initialValue = 1)
    @GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "user_id_sequense")
    private Integer id;

    @Column
    @NotBlank (message = "The username field cannot be empty and cannot have spaces.")
    @Pattern(regexp = "^[^\\/:*?\\\"<>|]+$", message = "The use of special characters is not allowed.")
    @Size (max = 20, message = "Maximum 20 characters allowed in this field")
    private String username;

    @Column
    @NotBlank
    @Pattern(regexp = "^[^\\/:*?\\\"<>|]+$", message = "The use of special characters is not allowed.")
    @Email(message = "Please enter a valid email format")
    @Size (max = 40, message = "Maximum 40 characters allowed in this field")
    private String email;


    @Column
    @NotBlank(message = "The password cannot be empty")
    @Size(max = 16, min = 8, message = "The password must have a minimum of 8 characters and a maximum of 16 characters.")
    private String password;

    @Column
    @Pattern(regexp = "^[^\\/:*?\\\"<>|]+$", message = "The use of special characters is not allowed.")
    @Size(max = 200, message = "Maximum 200 characters allowed in this field")
    private String description;

    @Column
    @NotBlank(message = "The contact cannot be empty")
    @Size(max = 150, message = "We suspect this isn't just a Discord link")
    private String discordLink;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
    name = "user_technologies",
    joinColumns = @JoinColumn(name = "user_id"),
    inverseJoinColumns = @JoinColumn(name = "technology_id")
    )
    private Set<Technologies> technologies = new HashSet<>();
    

}
