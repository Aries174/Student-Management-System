package com.hsf301.javafx.studentmanagementsystem.service.impl;

import com.hsf301.javafx.studentmanagementsystem.dto.BorrowRecordDTO;
import com.hsf301.javafx.studentmanagementsystem.entity.Book;
import com.hsf301.javafx.studentmanagementsystem.entity.BorrowRecord;
import com.hsf301.javafx.studentmanagementsystem.entity.User;
import com.hsf301.javafx.studentmanagementsystem.repository.BookRepository;
import com.hsf301.javafx.studentmanagementsystem.repository.BorrowRecordRepository;
import com.hsf301.javafx.studentmanagementsystem.repository.UserRepository;
import com.hsf301.javafx.studentmanagementsystem.service.BorrowRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class BorrowRecordImpl implements BorrowRecordService {
private final BorrowRecordRepository borrowRecordRepository;
private final UserRepository userRepository;
private final BookRepository bookRepository;
@Autowired
public BorrowRecordImpl(BorrowRecordRepository borrowRecordRepository, UserRepository userRepository, BookRepository bookRepository) {
    this.borrowRecordRepository = borrowRecordRepository;
    this.userRepository = userRepository;
    this.bookRepository = bookRepository;
}
    @Override
    public List<BorrowRecordDTO> getAllBorrowRecords() {
        List<BorrowRecord> borrowRecords = borrowRecordRepository.findAll();
        List<BorrowRecordDTO> borrowRecordDTOS = borrowRecords.stream().map(borrowRecord -> new BorrowRecordDTO(
                borrowRecord.getBorrowRecordID(),
                borrowRecord.getBorrowDate(),
                borrowRecord.getDueDate(),
                borrowRecord.getReturnDate(),
                borrowRecord.isStatus(),
                borrowRecord.getUser().getUserId(),
                borrowRecord.getBook().getBookID()
        )).toList();
        return borrowRecordDTOS;
    }

    @Override
    public void addBorrowRecord(BorrowRecordDTO borrowRecord) {
        if (borrowRecord.getUserID() == null) {
            throw new IllegalArgumentException("UserID cannot be null");
        }
        if (borrowRecord.getBookID() == null) {
            throw new IllegalArgumentException("BookID cannot be null");
        }
    User user=userRepository.findById(borrowRecord.getUserID()).orElseThrow(() -> new RuntimeException("User Not Found"));
        Book book=bookRepository.findById(borrowRecord.getBookID()).orElseThrow(() -> new RuntimeException("Book Not Found"));
        Date borrowDate;
        if(borrowRecord.getBorrowDate()!=null){
            borrowDate=borrowRecord.getBorrowDate();
        }else{
            borrowDate=new Date();
        }
        Calendar calendar=Calendar.getInstance();
        calendar.setTime(borrowDate);
        calendar.add(Calendar.DAY_OF_MONTH, 14);
        Date dueDate=calendar.getTime();
       BorrowRecord record = new BorrowRecord(borrowRecord.getBorrowDate(),dueDate,borrowRecord.getReturnDate(),true,user,book);
       borrowRecordRepository.save(record);
    }
}
