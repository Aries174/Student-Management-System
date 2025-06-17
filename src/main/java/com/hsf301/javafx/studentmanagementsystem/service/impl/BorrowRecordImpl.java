package com.hsf301.javafx.studentmanagementsystem.service.impl;

import com.hsf301.javafx.studentmanagementsystem.dto.BorrowRecordDTO;
import com.hsf301.javafx.studentmanagementsystem.entity.BorrowRecord;
import com.hsf301.javafx.studentmanagementsystem.repository.BorrowRecordRepository;
import com.hsf301.javafx.studentmanagementsystem.service.BorrowRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class BorrowRecordImpl implements BorrowRecordService {
private final BorrowRecordRepository borrowRecordRepository;
@Autowired
public BorrowRecordImpl(BorrowRecordRepository borrowRecordRepository) {
    this.borrowRecordRepository = borrowRecordRepository;
}
    @Override
    public List<BorrowRecordDTO> getAllBorrowRecords() {
        List<BorrowRecord> borrowRecords = borrowRecordRepository.findAll();
        List<BorrowRecordDTO> borrowRecordDTOS = borrowRecords.stream().map(borrowRecord -> new BorrowRecordDTO(
                borrowRecord.getBorrowRecordID(),
                borrowRecord.getBorrowDate(),
                borrowRecord.getDueDate(),
                borrowRecord.getReturnDate(),
                borrowRecord.isStatus()
        )).toList();
        return borrowRecordDTOS;
    }

    @Override
    public void addBorrowRecord(BorrowRecordDTO borrowRecord) {
       BorrowRecord record = new BorrowRecord(borrowRecord.getBorrowDate(),borrowRecord.getDueDate(),borrowRecord.getReturnDate(),true);
    }
}
