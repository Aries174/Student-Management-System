package com.hsf301.javafx.studentmanagementsystem.service.impl;

import com.hsf301.javafx.studentmanagementsystem.dto.CategoryDTO;
import com.hsf301.javafx.studentmanagementsystem.entity.Category;
import com.hsf301.javafx.studentmanagementsystem.repository.CategoryRepository;
import com.hsf301.javafx.studentmanagementsystem.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
    @Override
    public List<CategoryDTO> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        List<CategoryDTO> categoriesDTO = categories.stream().map(category -> new CategoryDTO(
                category.getCategoryId(),
                category.getCategoryName()
        )).toList();
        return categoriesDTO;
    }
}
