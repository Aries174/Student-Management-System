package com.hsf301.javafx.studentmanagementsystem.dto;

import com.hsf301.javafx.studentmanagementsystem.entity.Book;
import com.hsf301.javafx.studentmanagementsystem.entity.User;
import jakarta.persistence.Column;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class BorrowRecordDTO {
    private Integer  borrowRecordID;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date borrowDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dueDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date returnDate;
    private boolean status;
    private Integer  userID;
    private Integer  bookID;

    public BorrowRecordDTO() {
    }

    public BorrowRecordDTO(Integer borrowRecordID, Date borrowDate, Date dueDate, Date returnDate, boolean status, Integer userID, Integer bookID) {
        this.borrowRecordID = borrowRecordID;
        this.borrowDate = borrowDate;
        this.dueDate = dueDate;
        this.returnDate = returnDate;
        this.status = status;
        this.userID = userID;
        this.bookID = bookID;
    }

    public BorrowRecordDTO(Date borrowDate, Date dueDate, Date returnDate, boolean status, Integer  userID, Integer  bookID) {
        this.borrowDate = borrowDate;
        this.dueDate = dueDate;
        this.returnDate = returnDate;
        this.status = status;
        this.userID=userID;
        this.bookID=bookID;
    }

    public Integer getBorrowRecordID() {
        return borrowRecordID;
    }

    public void setBorrowRecordID(Integer borrowRecordID) {
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

    public Integer  getUserID() {
        return userID;
    }

    public void setUserID(Integer  userID) {
        this.userID = userID;
    }

    public Integer  getBookID() {
        return bookID;
    }

    public void setBookID(Integer  bookID) {
        this.bookID = bookID;
    }
}
