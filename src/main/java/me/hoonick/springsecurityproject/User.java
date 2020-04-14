package me.hoonick.springsecurityproject;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter @Getter
public class User {
    @Id
    private String username;
    private String password;
    private String email;
    private String role;
}