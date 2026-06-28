package com.lms.library.controller;

import com.lms.library.model.Book;
import com.lms.library.service.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    public Book getBook(@PathVariable int id) {
        return bookService.getBook(id);
    }

    @PostMapping
    public Book addBook(@Valid @RequestBody Book newBook) {
        return bookService.addBook(newBook);
    }

    @PutMapping("/{id}")
    public Book updateBook(@PathVariable int id,@Valid @RequestBody Book updatedBook) {
        return bookService.updateBook(id, updatedBook);
    }

    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable int id) {
        return bookService.deleteBook(id);
    }
}
