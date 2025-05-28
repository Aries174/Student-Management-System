package com.hsf301.javafx.studentmanagementsystem.dto;

import jakarta.persistence.Column;

import java.util.Date;

public class BorrowRecordDTO {
    private int borrowRecordID;
    private Date borrowDate;
    private Date dueDate;
    private Date returnDate;
    private boolean status;

    public BorrowRecordDTO() {
    }

    public BorrowRecordDTO(int borrowRecordID, Date borrowDate, Date dueDate, Date returnDate, boolean status) {
        this.borrowRecordID = borrowRecordID;
        this.borrowDate = borrowDate;
        this.dueDate = dueDate;
        this.returnDate = returnDate;
        this.status = status;
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
}
