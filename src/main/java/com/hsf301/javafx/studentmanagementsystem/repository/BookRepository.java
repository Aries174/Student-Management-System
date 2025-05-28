package com.hsf301.javafx.studentmanagementsystem.repository;

import com.hsf301.javafx.studentmanagementsystem.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BookRepository extends JpaRepository<Book, Integer> {
}
