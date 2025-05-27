package com.hsf301.javafx.studentmanagementsystem.entity;

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

    public BorrowRecord() {
    }

    public BorrowRecord(int borrowRecordID, Date borrowDate, Date dueDate, Date returnDate, boolean status) {
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
