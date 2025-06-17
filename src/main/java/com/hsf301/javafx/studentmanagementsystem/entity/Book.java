package com.hsf301.javafx.studentmanagementsystem.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.Set;

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
    @Column(name = "AvailableCopies")
    private int availableCopies;
    @Column(name = "totalCopies")
    private int totalCopies;
    @OneToMany(mappedBy = "book",cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<BorrowRecord> borrowRecords;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoryID",nullable = false,referencedColumnName = "categoryID")
    private Category category;
    public Book() {
    }

    public Book(String title, String author, int availableCopies, int totalCopies) {
        this.title = title;
        this.author = author;
        this.availableCopies = availableCopies;
        this.totalCopies = totalCopies;
    }

    public Book(String title, int bookID, String author, int availableCopies, int totalCopies, Category category) {
        this.title = title;
        this.bookID = bookID;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
