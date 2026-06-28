package com.lms.library.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "members")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Name Cant be Empty")
    private String name;

    @NotBlank(message = "Email Cant be Empty")
    @Email(message = "Invalid Email")
    private String email;

    // non-arg constructor for hibernate
    public Member() {}

    // constructor
    public Member(Integer id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public Integer getId() {  return id;  }
    public void setId(Integer id) {  this.id = id;  }

    public String getName() {  return name;  }
    public void setName(String name) {  this.name = name;  }

    public String getEmail() {  return email;  }
    public void setEmail(String email) {  this.email = email;  }
}
