package com.hsf301.javafx.studentmanagementsystem.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    @Column(name = "Name",columnDefinition = "NVARCHAR(255)")
    private String name;
    @Column(name = "Email",length = 255)
    private String email;
    @Column(name = "password",length = 255)
    private String password;
    @Column(name="role")
    private int role;

    public User() {
    }
    
    public User(String name, String email, String password, int role) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }
}
