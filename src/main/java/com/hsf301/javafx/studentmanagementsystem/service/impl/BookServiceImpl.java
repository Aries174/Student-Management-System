package com.hsf301.javafx.studentmanagementsystem.service.impl;

import com.hsf301.javafx.studentmanagementsystem.dto.BookDTO;
import com.hsf301.javafx.studentmanagementsystem.entity.Book;
import com.hsf301.javafx.studentmanagementsystem.entity.Category;
import com.hsf301.javafx.studentmanagementsystem.repository.BookRepository;
import com.hsf301.javafx.studentmanagementsystem.repository.CategoryRepository;
import com.hsf301.javafx.studentmanagementsystem.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final CategoryRepository categoryRepository;
    @Autowired
    public BookServiceImpl(BookRepository bookRepository, CategoryRepository categoryRepository) {
        this.bookRepository = bookRepository;
        this.categoryRepository = categoryRepository;
    }
    @Override
    public List<BookDTO> getAllBooks() {
        List<Book> books=bookRepository.findAll();
        List<BookDTO> bookDTOs=books.stream().map(book -> new BookDTO(
                book.getBookID(),
                book.getTitle(),
                book.getAuthor(),
                book.getAvailableCopies(),
                book.getTotalCopies(),
                book.getCategory()
        )).toList();
        return bookDTOs;
    }

    @Override
    public List<BookDTO> getAllBookCategory(int categoryID) {
        List<Book>books=bookRepository.findByCategory_CategoryId(categoryID);
        List<BookDTO> bookDTOs=books.stream().map(book -> new BookDTO(
                book.getBookID(),
                book.getTitle(),
                book.getAuthor(),
                book.getAvailableCopies(),
                book.getTotalCopies(),
                book.getCategory()
        )).toList();
        return bookDTOs;
    }

    @Override
    public List<BookDTO> searchBookByName(String bookName) {
        List<Book> books=bookRepository.findByTitleContainingIgnoreCase(bookName);
        List<BookDTO> bookDTOs=books.stream().map(book -> new BookDTO(
                book.getBookID(),
                book.getTitle(),
                book.getAuthor(),
                book.getAvailableCopies(),
                book.getTotalCopies(),
                book.getCategory()
        )).toList();
        return bookDTOs;
    }

    @Override
    public BookDTO getBookById(int id) {
        return bookRepository.findById(id).map(book -> new BookDTO(
                book.getBookID(),
                book.getTitle(),
                book.getAuthor(),
                book.getAvailableCopies(),
                book.getTotalCopies(),
                book.getCategory()
        )).orElse(null);
    }

    @Override
    public void insertBook(BookDTO bookDTO) {
        Category category=categoryRepository.findById(bookDTO.getCategoryId()).orElseThrow(()->new RuntimeException("Category not found"));
        Book book=new Book(bookDTO.getTitle(),bookDTO.getAuthor(),bookDTO.getAvailableCopies(),bookDTO.getTotalCopies(),category);
        bookRepository.save(book);
    }

}
