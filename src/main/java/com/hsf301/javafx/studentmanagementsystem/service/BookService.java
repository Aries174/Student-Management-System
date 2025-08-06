package com.hsf301.javafx.studentmanagementsystem.service;

import com.hsf301.javafx.studentmanagementsystem.dto.BookDTO;

import java.awt.print.Book;
import java.util.List;

public interface BookService {
    public List<BookDTO> getAllBooks();
    public List<BookDTO> getAllBookCategory(int categoryID);
    public List<BookDTO> searchBookByName(String bookName);
    public BookDTO getBookById(int id);
    public void insertBook(BookDTO bookDTO);
    public void deleteBook(int id);
    public void updateBook(BookDTO bookDTO);
    public BookDTO getBook(int id);
}
