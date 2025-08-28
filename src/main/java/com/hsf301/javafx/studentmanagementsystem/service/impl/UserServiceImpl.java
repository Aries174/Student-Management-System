package com.hsf301.javafx.studentmanagementsystem.service.impl;

import com.hsf301.javafx.studentmanagementsystem.dto.RoleDTO;
import com.hsf301.javafx.studentmanagementsystem.dto.UserDTO;
import com.hsf301.javafx.studentmanagementsystem.entity.Role;
import com.hsf301.javafx.studentmanagementsystem.entity.User;
import com.hsf301.javafx.studentmanagementsystem.repository.RoleRepository;
import com.hsf301.javafx.studentmanagementsystem.repository.UserRepository;
import com.hsf301.javafx.studentmanagementsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserServiceImpl implements UserService {
    public final UserRepository userRepository;
    public final RoleRepository roleRepository;
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public void registerUser(UserDTO user) {
        Role studentRole=roleRepository.findById(1).orElseThrow(()->new IllegalArgumentException("Student Role Not Found"));
        User newUser=new User();
        newUser.setName(user.getName());
        newUser.setPassword(passwordEncoder.encode(user.getPassword()));
        newUser.setEmail(user.getEmail());
        newUser.setConfirmPassword(user.getConfirmPassword());
        newUser.setRole(studentRole);
        userRepository.save(newUser);
    }


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user=userRepository.findByEmail(email).orElseThrow(()->new UsernameNotFoundException("User not found"));
        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getEmail())
                .password(user.getPassword())
                .authorities(new SimpleGrantedAuthority("ROLE_"+user.getRole().getRoleName())) // phải là ROLE_*
                .build();
    }

    @Override
    public UserDTO findByEmail(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        RoleDTO roleDTO = new RoleDTO(
                user.getRole().getRoleId(),
                user.getRole().getRoleName()
        );
        UserDTO dto = new UserDTO();
        dto.setUserId(user.getUserId());
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        dto.setPassword(user.getPassword());
        dto.setRole(roleDTO);
        return dto;
    }

}
