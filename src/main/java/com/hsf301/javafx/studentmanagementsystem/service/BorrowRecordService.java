package com.hsf301.javafx.studentmanagementsystem.service;

import com.hsf301.javafx.studentmanagementsystem.dto.BorrowRecordDTO;

import java.util.List;

public interface BorrowRecordService {
    public List<BorrowRecordDTO> getAllBorrowRecords();
    public void addBorrowRecord(BorrowRecordDTO borrowRecord);
}
