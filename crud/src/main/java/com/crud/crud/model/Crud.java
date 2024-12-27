package com.crud.crud.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Entity
@Data
public class Crud {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Pattern(regexp = "^[a-zA-Z ]*$", message = "Name should contain only alphabets")
    private String name;
    @Email (message = "Email should be valid")
    private String email;
    @Pattern(regexp = "^[a-zA-Z0-9 ]*$", message = "Address should not contain special characters")
    private String address;


}
