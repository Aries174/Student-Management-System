package com.hsf301.javafx.studentmanagementsystem.dto;

import com.hsf301.javafx.studentmanagementsystem.entity.Category;
import jakarta.persistence.Column;

public class BookDTO {
    private int bookID;
    private String title;
    private String author;
    private int availableCopies;
    private int totalCopies;
    private Category category;
    public BookDTO() {
    }

    public BookDTO(int bookID, String title, String author, int availableCopies, int totalCopies) {
        this.bookID = bookID;
        this.title = title;
        this.author = author;
        this.availableCopies = availableCopies;
        this.totalCopies = totalCopies;
    }

    public BookDTO(int bookID,String title, String author, int availableCopies, int totalCopies, Category category) {
        this.bookID = bookID;
        this.title = title;
        this.author = author;
        this.availableCopies = availableCopies;
        this.totalCopies = totalCopies;
        this.category = category;
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
