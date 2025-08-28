package com.hsf301.javafx.studentmanagementsystem.dto;

import com.hsf301.javafx.studentmanagementsystem.entity.Category;

public class BookDTO {
    private int bookID;
    private String title;
    private String author;
    private int availableCopies;
    private int totalCopies;
    private int categoryId;
    private String categoryName;
    public BookDTO(int bookID, String title, String author, int availableCopies, int totalCopies, Category category) {
        this.bookID = bookID;
        this.title = title;
        this.author = author;
        this.availableCopies = availableCopies;
        this.totalCopies = totalCopies;
        this.categoryId=category.getCategoryId();
        this.categoryName=category.getCategoryName();
    }
    public BookDTO(String title, String author, int availableCopies, int totalCopies, int categoryId) {
        this.title = title;
        this.author = author;
        this.availableCopies = availableCopies;
        this.totalCopies = totalCopies;
        this.categoryId = categoryId;
    }


    public BookDTO() {

    }

    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getAvailableCopies() {
        return availableCopies;
    }

    public void setAvailableCopies(int availableCopies) {
        this.availableCopies = availableCopies;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getTotalCopies() {
        return totalCopies;
    }

    public void setTotalCopies(int totalCopies) {
        this.totalCopies = totalCopies;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
