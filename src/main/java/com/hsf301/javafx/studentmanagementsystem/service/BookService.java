package com.hsf301.javafx.studentmanagementsystem.service;

import com.hsf301.javafx.studentmanagementsystem.dto.BookDTO;

import java.awt.print.Book;
import java.util.List;

public interface BookService {
    public List<BookDTO> getAllBooks();
}
