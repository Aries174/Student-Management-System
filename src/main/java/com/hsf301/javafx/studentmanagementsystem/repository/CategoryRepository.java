package com.hsf301.javafx.studentmanagementsystem.repository;

import com.hsf301.javafx.studentmanagementsystem.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
