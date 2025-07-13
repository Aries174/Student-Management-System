package com.hsf301.javafx.studentmanagementsystem.controller;

import com.hsf301.javafx.studentmanagementsystem.dto.BookDTO;
import com.hsf301.javafx.studentmanagementsystem.service.BookService;
import com.hsf301.javafx.studentmanagementsystem.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HomeController {
    private final BookService bookService;
    private final CategoryService categoryService;
    @Autowired
    public HomeController(BookService bookService, CategoryService categoryService) {
        this.bookService = bookService;
        this.categoryService = categoryService;
    }
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("books", bookService.getAllBooks());
        model.addAttribute("categories", categoryService.getAllCategories());
        return "homepage";
    }
    @GetMapping("/reserveBook")
    public String reserveBook(@RequestParam("id") int id, Model model) {
        BookDTO book = bookService.getBookById(id);
        model.addAttribute("book", book);
        return "reserveBook"; // trang chỉ có form/modal
    }
    @GetMapping("/category")
    public String booksByCategory(@RequestParam("id") int id, Model model) {
        model.addAttribute("bookDTOS", bookService.getAllBookCategory(id));
        model.addAttribute("books", bookService.getAllBooks());
        model.addAttribute("categories", categoryService.getAllCategories());
        return "category";
    }
    @GetMapping("/searchBook")
    public String search(@RequestParam("keyword") String keyword, Model model) {
        model.addAttribute("searchBook",bookService.searchBookByName(keyword));
        model.addAttribute("categories", categoryService.getAllCategories());
        return "searchBook";
    }

}
