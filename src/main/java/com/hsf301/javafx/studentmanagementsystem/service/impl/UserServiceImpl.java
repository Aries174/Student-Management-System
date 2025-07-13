package com.hsf301.javafx.studentmanagementsystem.service.impl;

import com.hsf301.javafx.studentmanagementsystem.dto.UserDTO;
import com.hsf301.javafx.studentmanagementsystem.entity.Role;
import com.hsf301.javafx.studentmanagementsystem.entity.User;
import com.hsf301.javafx.studentmanagementsystem.repository.RoleRepository;
import com.hsf301.javafx.studentmanagementsystem.repository.UserRepository;
import com.hsf301.javafx.studentmanagementsystem.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    public final UserRepository userRepository;
    public final RoleRepository roleRepository;
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }
    @Override
    public void registerUser(UserDTO user) {
        Role studentRole=roleRepository.findById(1).orElseThrow(()->new IllegalArgumentException("Student Role Not Found"));
        User newUser=new User();
        newUser.setName(user.getName());
        newUser.setPassword(user.getPassword());
        newUser.setEmail(user.getEmail());
        newUser.setConfirmPassword(user.getConfirmPassword());
        newUser.setRole(studentRole);
        userRepository.save(newUser);
    }

    @Override
    public UserDTO loginUser(UserDTO user) {
        Optional<User> optionalUser=userRepository.findByEmail(user.getEmail());
        if(optionalUser.isPresent()){
            User existingUser=optionalUser.get();
            if(existingUser.getPassword().equals(user.getPassword())){
                UserDTO userDTO=new UserDTO();
                userDTO.setEmail(existingUser.getEmail());
                userDTO.setName(existingUser.getName());
                userDTO.setPassword(existingUser.getPassword());
                return userDTO;
            }else{
                throw new IllegalArgumentException("Wrong Password");
            }
        }else{
            throw new IllegalArgumentException("Wrong Email");
        }
    }
}
