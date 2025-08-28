package com.hsf301.javafx.studentmanagementsystem.entity;

import com.hsf301.javafx.studentmanagementsystem.dto.BookDTO;
import com.hsf301.javafx.studentmanagementsystem.dto.UserDTO;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "BorrowRecord")
public class BorrowRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int borrowRecordID;
    @Column(name = "borrow_date")
    private Date borrowDate;
    @Column(name = "due_date")
    private Date dueDate;
    @Column(name = "return_date")
    private Date returnDate;
    @Column(name = "Status")
    private boolean status;
    @ManyToOne
    @JoinColumn(name = "userID",nullable = false,referencedColumnName = "userID")
    private User user;

    @ManyToOne
    @JoinColumn(name = "bookID",nullable = false,referencedColumnName = "bookID")
    private Book book;

    public BorrowRecord() {
    }

    public BorrowRecord(int borrowRecordID, Date borrowDate, Date dueDate, Date returnDate, boolean status, User user, Book book) {
        this.borrowRecordID = borrowRecordID;
        this.borrowDate = borrowDate;
        this.dueDate = dueDate;
        this.returnDate = returnDate;
        this.status = status;
        this.user = user;
        this.book = book;
    }

    public BorrowRecord(Date borrowDate, Date dueDate, Date returnDate, boolean status, User user, Book book) {
        this.borrowDate = borrowDate;
        this.dueDate = dueDate;
        this.returnDate = returnDate;
        this.status = status;
        this.user = user;
        this.book = book;
    }

    public BorrowRecord(int borrowRecordID, Date borrowDate, Date dueDate, Date returnDate, boolean b) {
        this.borrowRecordID = borrowRecordID;
        this.borrowDate = borrowDate;
        this.dueDate = dueDate;
        this.returnDate = returnDate;
        this.status = b;
    }

    public int getBorrowRecordID() {
        return borrowRecordID;
    }

    public void setBorrowRecordID(int borrowRecordID) {
        this.borrowRecordID = borrowRecordID;
    }

    public Date getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(Date borrowDate) {
        this.borrowDate = borrowDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
