package com.lms.library.service;

import com.lms.library.exception.ResourceNotFoundException;
import com.lms.library.model.Book;
import com.lms.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book getBook(int id) {
        return bookRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Book Not Found"));
    }

    public Book addBook(Book newBook) {
        return bookRepository.save(newBook);
    }

    public Book updateBook(int id, Book updatedBook) {
        if(bookRepository.existsById(id)) {
            updatedBook.setId(id);
            return bookRepository.save(updatedBook);
        }
        throw new ResourceNotFoundException("Book Not Found");
    }

    public String deleteBook(int id) {
        if(bookRepository.existsById(id)) {
            bookRepository.deleteById(id);
            return "Book Deleted Successfully";
        }
        throw new ResourceNotFoundException("Book Not Found");
    }
}
