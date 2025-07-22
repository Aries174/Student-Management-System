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

    @Override
    public void addCategory(CategoryDTO category) {
        Category categoryEntity = new Category(category.getCategoryName());
        categoryRepository.save(categoryEntity);
    }

    @Override
    public void deleteCategory(int id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public void updateCategory(CategoryDTO category) {
        Category existing=categoryRepository.findById(category.getCategoryId()).orElseThrow(()->new RuntimeException("Category not found"));
        existing.setCategoryName(category.getCategoryName());
        categoryRepository.save(existing);
    }

    @Override
    public CategoryDTO getCategory(int id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy thể loại"));

        return new CategoryDTO(category.getCategoryId(), category.getCategoryName());
    }

}
