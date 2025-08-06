package com.hsf301.javafx.studentmanagementsystem.controller;

import com.hsf301.javafx.studentmanagementsystem.dto.BookDTO;
import com.hsf301.javafx.studentmanagementsystem.service.BookService;
import com.hsf301.javafx.studentmanagementsystem.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AdminBook {
    private final BookService bookService;
    private final CategoryService categoryService;
    @Autowired
    public AdminBook(BookService bookService, CategoryService categoryService) {
        this.bookService = bookService;
        this.categoryService = categoryService;
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
    @GetMapping("/editBook/{id}")
    public String editBook(@PathVariable int id, Model model) {
        BookDTO bookDTO = bookService.getBookById(id);
        model.addAttribute("editBook", bookDTO);
        model.addAttribute("category", categoryService.getAllCategories());
        return "editBook"; // Có thể tái sử dụng form thêm
    }

    @PostMapping("/updateBook")
    public String updateBook(@ModelAttribute("editCategory") BookDTO bookDTO, Model model) {
        bookService.updateBook(bookDTO);
        return "redirect:/admin";
    }
    @GetMapping("/deleteBook")
    public String deleteBook(@RequestParam("id") int id, Model model) {
        bookService.deleteBook(id);
        return "redirect:/admin";
    }
}
