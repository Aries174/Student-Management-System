package com.hsf301.javafx.studentmanagementsystem.controller;

import com.hsf301.javafx.studentmanagementsystem.dto.UserDTO;
import com.hsf301.javafx.studentmanagementsystem.entity.User;
import com.hsf301.javafx.studentmanagementsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import jakarta.validation.Valid;
@Controller
public class LoginController {
    private final UserService userService;
    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/login")
    public String login( Model model) {
        model.addAttribute("register", new UserDTO());
        return "login";
    }
    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("register") UserDTO userDTO,Model model) {
        userService.registerUser(userDTO);
        return "login";
    }
    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("login") UserDTO userDTO,Model model) {
        try{
            UserDTO user = userService.loginUser(userDTO);
            model.addAttribute("user", user);
            return "redirect:/home";
        }catch(IllegalArgumentException e){
            model.addAttribute("error", e.getMessage());
            return "login";
        }
    }
}
