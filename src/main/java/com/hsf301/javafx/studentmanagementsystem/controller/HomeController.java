package com.hsf301.javafx.studentmanagementsystem.controller;

import com.hsf301.javafx.studentmanagementsystem.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    private final BookService bookService;
    @Autowired
    public HomeController(BookService bookService) {
        this.bookService = bookService;
    }
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("books", bookService.getAllBooks());
        return "homepage";
    }
}
