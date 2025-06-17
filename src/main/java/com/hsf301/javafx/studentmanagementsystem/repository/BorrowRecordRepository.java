package com.hsf301.javafx.studentmanagementsystem.repository;

import com.hsf301.javafx.studentmanagementsystem.entity.BorrowRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BorrowRecordRepository extends JpaRepository<BorrowRecord,Integer> {
}
