package com.hsf301.javafx.studentmanagementsystem.controller;

import com.hsf301.javafx.studentmanagementsystem.dto.BookDTO;
import com.hsf301.javafx.studentmanagementsystem.dto.BorrowRecordDTO;
import com.hsf301.javafx.studentmanagementsystem.service.BookService;
import com.hsf301.javafx.studentmanagementsystem.service.BorrowRecordService;
import com.hsf301.javafx.studentmanagementsystem.service.CategoryService;
import com.hsf301.javafx.studentmanagementsystem.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class HomeController {
    private final BookService bookService;
    private final CategoryService categoryService;
    private final BorrowRecordService borrowRecordService;
    @Autowired
    public HomeController(BookService bookService, CategoryService categoryService, BorrowRecordService borrowRecordService) {
        this.bookService = bookService;
        this.categoryService = categoryService;
        this.borrowRecordService = borrowRecordService;
    }
    @GetMapping("/")
    public String redirectToHome() {
        return "redirect:/home";
    }
    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("books", bookService.getAllBooks());
        model.addAttribute("categories", categoryService.getAllCategories());
        return "homepage";
    }
    @GetMapping("/reserveBook")
    public String reserveBook(@RequestParam("id") int id, Model model) {
        BookDTO book = bookService.getBookById(id);
        model.addAttribute("categories", categoryService.getAllCategories());
        model.addAttribute("book", book);
        return "reserveBook"; // trang chỉ có form/modal
    }
    @PostMapping("/reserveBook")
    public String reserveBook(@ModelAttribute("reserveBook") BorrowRecordDTO borrow, @RequestParam("bookID") Integer bookID,
                              HttpSession session, RedirectAttributes redirectAttributes) {
        Integer userID = (Integer) session.getAttribute("userID");
        if(userID == null) {
            throw new RuntimeException("You need to login first");
        }
        borrow.setUserID(userID);
        borrow.setBookID(bookID);
        if (borrow.getBorrowDate() != null && borrow.getReturnDate() != null) {
            if (borrow.getBorrowDate().equals(borrow.getReturnDate())) {
                redirectAttributes.addFlashAttribute("message", "Ngày mượn và ngày trả không được trùng nhau!");
                return "redirect:/reserveBook?id=" + borrow.getBookID();
            }
        }
        borrowRecordService.addBorrowRecord(borrow);
        redirectAttributes.addFlashAttribute("messageSuccess","Successfully Borrow Book");
        return "redirect:/home";
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
