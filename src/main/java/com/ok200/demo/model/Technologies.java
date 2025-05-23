package com.ok200.demo.model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "technologies")
@Getter
@Setter
@NoArgsConstructor
public class Technologies {

 @Id
 @SequenceGenerator(name = "technologies_id_sequense", sequenceName = "technologies_id_sequense", allocationSize = 1, initialValue = 1)
 @GeneratedValue(strategy = GenerationType.SEQUENCE, generator ="technologies_id_sequense")
 private Integer id;
 
@Column
@NotBlank (message = "The field cannot be empty and cannot have spaces.")
@Pattern(regexp = "^[^\\/:*?\\\"<>|]+$", message = "The use of special characters is not allowed.")
@Size (max = 20, message = "Maximum 20 characters allowed in this field")
private String name;

@ManyToMany(mappedBy = "technologies")
@JsonIgnore
private Set<User> users = new HashSet<>();


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Technologies)) return false;
        Technologies that = (Technologies) o;
        return id != null && id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}