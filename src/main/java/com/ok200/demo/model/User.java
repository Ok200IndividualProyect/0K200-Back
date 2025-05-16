package com.ok200.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
    @NotBlank (message = " El campo de username no puede estar vacio y tampoco tener espacios")
    @Pattern(regexp = "^[^\\/:*?\\\"<>|]+$", message = "No está permitido el uso de caracteres especiales")
    @Size (max = 20, message = " Máximo de 20 caracteres permitidos en este campo")
    private String username;

    @Column
    @NotBlank
    @Email(message = "Por favor, ingrese un formato válido de email")
    private String email;

    @Column
    @NotBlank(message = "La contraseña no puede estar vacía")
    @Size(max = 16, min = 8, message = "La contraseña debe de tener un minimo de 8 caracteres y un máximo de 16 caracteres")
    private String password;

    @Column
    @Pattern(regexp = "^[^\\/:*?\\\"<>|]+$", message = "No está permitido el uso de caracteres especiales")
    @Size(max = 200, message = "Máximo de 200 caracteres permitidos en este campo")
    private String description;

    @Column
    @NotBlank(message = "El contacto no puede estar vacío")
    @Size(max = 100, message = "Sospechamos que esto no es solo un link de Discord")
    private String discordLink;

    

}
