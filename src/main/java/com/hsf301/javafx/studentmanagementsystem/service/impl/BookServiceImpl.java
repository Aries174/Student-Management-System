package com.hsf301.javafx.studentmanagementsystem.service.impl;

import com.hsf301.javafx.studentmanagementsystem.dto.BookDTO;
import com.hsf301.javafx.studentmanagementsystem.entity.Book;
import com.hsf301.javafx.studentmanagementsystem.repository.BookRepository;
import com.hsf301.javafx.studentmanagementsystem.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    @Override
    public List<BookDTO> getAllBooks() {
        List<Book> books=bookRepository.findAll();
        List<BookDTO> bookDTOs=books.stream().map(book -> new BookDTO(
                book.getBookID(),
                book.getTitle(),
                book.getAuthor(),
                book.getAvailableCopies(),
                book.getTotalCopies()
        )).toList();
        return bookDTOs;
    }
}
