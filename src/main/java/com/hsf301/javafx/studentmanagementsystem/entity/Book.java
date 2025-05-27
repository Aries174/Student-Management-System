package com.hsf301.javafx.studentmanagementsystem.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookID;
    @Column(name = "Title",columnDefinition = "NVARCHAR(255)")
    private String title;
    @Column(name = "Author",columnDefinition = "NVARCHAR(255)")
    private String author;
    @Column(name = "Category",columnDefinition = "NVARCHAR(255)")
    private String category;
    @Column(name = "AvailableCopies")
    private int availableCopies;
    @Column(name = "totalCopies")
    private int totalCopies;

    public Book() {
    }

    public Book(String title, String author, String category, int availableCopies, int totalCopies) {
        this.title = title;
        this.author = author;
        this.category = category;
        this.availableCopies = availableCopies;
        this.totalCopies = totalCopies;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getAvailableCopies() {
        return availableCopies;
    }

    public void setAvailableCopies(int availableCopies) {
        this.availableCopies = availableCopies;
    }

    public int getTotalCopies() {
        return totalCopies;
    }

    public void setTotalCopies(int totalCopies) {
        this.totalCopies = totalCopies;
    }
}
