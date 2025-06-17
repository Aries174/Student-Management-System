package com.hsf301.javafx.studentmanagementsystem.repository;

import com.hsf301.javafx.studentmanagementsystem.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface BookRepository extends JpaRepository<Book, Integer> {
    List<Book> findByCategory_CategoryId(int categoryCategoryId);
    List<Book> findByTitleContainingIgnoreCase(String bookTitle);
}
