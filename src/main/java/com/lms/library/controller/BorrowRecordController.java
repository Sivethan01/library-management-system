package com.lms.library.controller;

import com.lms.library.model.BorrowRecord;
import com.lms.library.service.BorrowRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BorrowRecordController {
    @Autowired
    private BorrowRecordService borrowRecordService;

    @PostMapping("/borrow/{memberId}/{bookId}")
    public BorrowRecord borrowBook(@PathVariable Integer memberId, @PathVariable Integer bookId) {
        return borrowRecordService.borrowBook(memberId, bookId);
    }

    @PutMapping("/return/{borrowRecordId}")
    public BorrowRecord returnBook(@PathVariable Integer borrowRecordId) {
        return borrowRecordService.returnBook(borrowRecordId);
    }

    @GetMapping("/borrow/all")
    public List<BorrowRecord> getAllRecords() {
        return borrowRecordService.getAllRecords();
    }
}
