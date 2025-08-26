package com.hsf301.javafx.studentmanagementsystem.dto;

import com.hsf301.javafx.studentmanagementsystem.entity.Role;
import jakarta.persistence.Column;

public class UserDTO {
    private int userId;
    private String name;
    private String email;
    private String password;
    private String confirmPassword;
    private RoleDTO role;
    public UserDTO() {
    }

    public UserDTO(int userId, String name, String email, String password, String confirmPassword,RoleDTO role) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.role = role;

    }

    public UserDTO(int userId, String name, String email, String password, String confirmPassword) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
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

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public RoleDTO getRole() {
        return role;
    }

    public void setRole(RoleDTO role) {
        this.role = role;
    }
}
