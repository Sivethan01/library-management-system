package com.lms.library.service;

import com.lms.library.exception.ResourceNotFoundException;
import com.lms.library.model.Book;
import com.lms.library.model.BorrowRecord;
import com.lms.library.model.Member;
import com.lms.library.repository.BookRepository;
import com.lms.library.repository.BorrowRecordRepository;
import com.lms.library.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class BorrowRecordService {

    @Autowired
    private BorrowRecordRepository borrowRecordRepository;
    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private BookRepository bookRepository;

    public BorrowRecord borrowBook(Integer memberId, Integer bookId) {

        // check whether both the member and book exist or not
        Optional<Member> memberExistence = memberRepository.findById(memberId);
        Optional<Book> bookExistence = bookRepository.findById(bookId);

        if(memberExistence.isEmpty()) { throw new ResourceNotFoundException("Member Not Found"); }
        if(bookExistence.isEmpty()) { throw new ResourceNotFoundException("Book Not Found"); }

        // check book availability
        Book book = bookExistence.get();
        if(!book.isAvailable()) { throw new ResourceNotFoundException("Book Not Available Right Now"); }

        // set book unavailable
        book.setAvailable(false);
        bookRepository.save(book);

        // create a borrow record
        BorrowRecord borrowRecord = new BorrowRecord();
        borrowRecord.setMember(memberExistence.get());
        borrowRecord.setBook(book);
        borrowRecord.setBorrowDate(LocalDate.now());
        borrowRecord.setReturnDate(null);
        return borrowRecordRepository.save(borrowRecord);
    }

    public BorrowRecord returnBook(Integer borrowRecordId) {
        Optional<BorrowRecord> existence = borrowRecordRepository.findById(borrowRecordId);
        if(existence.isEmpty()) { throw new ResourceNotFoundException("Borrow Record Not Found"); }
        BorrowRecord borrowRecord = existence.get();

        // set book available
        Book book = borrowRecord.getBook();
        book.setAvailable(true);
        bookRepository.save(book);

        // set return date
        borrowRecord.setReturnDate(LocalDate.now());
        return borrowRecordRepository.save(borrowRecord);
    }

    public List<BorrowRecord> getAllRecords() {
        return borrowRecordRepository.findAll();
    }
}
