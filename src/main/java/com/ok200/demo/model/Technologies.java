package com.ok200.demo.model;

// import java.util.HashSet;

// import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
// import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
// import jakarta.validation.constraints.Pattern;
// import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Table(name = "technologies")
@Data
public class Technologies {

 @Id
 @SequenceGenerator(name = "technologies_id_sequense", sequenceName = "technologies_id_sequense", allocationSize = 1, initialValue = 1)
 @GeneratedValue(strategy = GenerationType.SEQUENCE, generator ="technologies_id_sequense")
 private Integer id;
 
@Column
@NotBlank (message = " El campo de username no puede estar vacio y tampoco tener espacios")
// @Pattern(regexp = "^[^\\/:*?\\\"<>|]+$", message = "No está permitido el uso de caracteres especiales")
// @Size (max = 20, message = " Máximo de 20 caracteres permitidos en este campo")
private String name;

// @ManyToMany(mappedBy = "technologies")
// private Set<User> users = new HashSet<>();


public  Technologies (String name) {
this.name = name;
} 

}