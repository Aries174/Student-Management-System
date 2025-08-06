package com.hsf301.javafx.studentmanagementsystem.controller;

import com.hsf301.javafx.studentmanagementsystem.dto.BookDTO;
import com.hsf301.javafx.studentmanagementsystem.dto.CategoryDTO;
import com.hsf301.javafx.studentmanagementsystem.service.BookService;
import com.hsf301.javafx.studentmanagementsystem.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AdminController {
    private final BookService bookService;
    private final CategoryService categoryService;
    @Autowired
    public AdminController(BookService bookService, CategoryService categoryService) {
        this.bookService = bookService;
        this.categoryService = categoryService;
    }
    @GetMapping("/admin")
    public String admin(Model model) {
        model.addAttribute("books", bookService.getAllBooks());
        model.addAttribute("categories", categoryService.getAllCategories());
        return "Admin";
    }
}
