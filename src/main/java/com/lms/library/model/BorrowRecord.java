package com.lms.library.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "borrow_records")
public class BorrowRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    private LocalDate borrowDate;
    private LocalDate returnDate;

    // non-arg constructor for hibernate
    public BorrowRecord() {}

    public BorrowRecord(Integer id, Member member, Book book, LocalDate borrowDate, LocalDate returnDate) {
        this.id = id;
        this.member = member;
        this.book = book;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
    }

    public Integer getId() {  return id;  }
    public void setId(Integer id) {  this.id = id;  }

    public Member getMember() { return member; }
    public void setMember(Member member) { this.member = member; }

    public Book getBook() { return book; }
    public void setBook(Book book) { this.book = book; }

    public LocalDate getBorrowDate() {  return borrowDate;  }
    public void setBorrowDate(LocalDate borrowDate) {  this.borrowDate = borrowDate;  }

    public LocalDate getReturnDate() {  return returnDate;  }
    public void setReturnDate(LocalDate returnDate) {  this.returnDate = returnDate;  }

}
