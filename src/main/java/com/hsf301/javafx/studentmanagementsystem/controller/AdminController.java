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
    @GetMapping("/addBook")
    public String addBook(Model model) {
        model.addAttribute("categories", categoryService.getAllCategories());
        model.addAttribute("addBook",new BookDTO());
        return "addBook";
    }
    @PostMapping("/addBook")
    public String addBook(@ModelAttribute("addBook") BookDTO book) {
        bookService.insertBook(book);
        return "redirect:/admin";
    }
    @GetMapping("/listCategory")
    public String listCategory(Model model) {
        model.addAttribute("categories", categoryService.getAllCategories());
        return "listCategory";
    }
    @GetMapping("/addCategory")
    public String addCategory(Model model) {
        model.addAttribute("addCategory",new CategoryDTO());
        return "addCategory";
    }
    @PostMapping("/addCategory")
    public String addCategory(@ModelAttribute("addCategory") CategoryDTO category) {
        categoryService.addCategory(category);
        return "redirect:/listCategory";
    }
    @GetMapping("/delete")
    public String delete(@RequestParam("id")int id, Model model) {
        categoryService.deleteCategory(id);
        return "redirect:/listCategory";
    }
    @GetMapping("/editCategory/{id}")
    public String editCategory(@PathVariable int id, Model model) {
        CategoryDTO categoryDTO = categoryService.getCategory(id);
        model.addAttribute("editCategory", categoryDTO);
        return "editCategory"; // Có thể tái sử dụng form thêm
    }

    @PostMapping("/updateCategory")
    public String updateCategory(@ModelAttribute("editCategory") CategoryDTO categoryDTO) {
        categoryService.updateCategory(categoryDTO);
        return "redirect:/listCategory";
    }
}
