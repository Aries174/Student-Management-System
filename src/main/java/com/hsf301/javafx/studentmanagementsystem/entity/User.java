package com.hsf301.javafx.studentmanagementsystem.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.Set;

@Entity
@Table(name = "[User]")
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
    @NotBlank(message = "Confirm password is required")
    private String confirmPassword;
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<BorrowRecord> borrowRecords;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "roleID",referencedColumnName = "roleID")
    @JsonManagedReference
    private Role role;
    public User() {
    }

    public User(int userId, String name, String email, String password, String confirmPassword,Role role) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
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

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
