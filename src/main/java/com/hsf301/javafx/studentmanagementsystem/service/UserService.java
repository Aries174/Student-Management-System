package com.hsf301.javafx.studentmanagementsystem.service;

import com.hsf301.javafx.studentmanagementsystem.dto.UserDTO;
import com.hsf301.javafx.studentmanagementsystem.entity.User;

public interface UserService {
    public void registerUser(UserDTO user);
    public UserDTO loginUser(UserDTO user);
}
