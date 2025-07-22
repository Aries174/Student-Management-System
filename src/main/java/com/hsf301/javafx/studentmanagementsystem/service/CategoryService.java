package com.hsf301.javafx.studentmanagementsystem.service;

import com.hsf301.javafx.studentmanagementsystem.dto.CategoryDTO;

import java.util.List;

public interface CategoryService {
    public List<CategoryDTO> getAllCategories();
    public void addCategory(CategoryDTO category);
    public void deleteCategory(int id);
    public void updateCategory(CategoryDTO category);
    public CategoryDTO getCategory(int id);
}
