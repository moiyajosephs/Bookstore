package com.company.bookstore.controller;

import com.company.bookstore.model.Book;
import com.company.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {

    @Autowired
    BookRepository bookRepository;

    // A POST route that creates a new book
    @PostMapping("/books")
    @ResponseStatus(HttpStatus.CREATED)
    public Book addBook(@RequestBody Book book) {
        return bookRepository.save(book);
    }

    // A GET route that returns a specific customer by id
    @GetMapping("/books/{id}")
    public Book getBookbyId(@PathVariable int id) {
        Optional<Book> returnedBook = bookRepository.findById(id);
        return returnedBook.orElse(null);
    }

    // A GET route that get all book
    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    // A PUT route that updates book
    @PutMapping("/books")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Book updateBook(@RequestBody Book book) {
        return bookRepository.save(book);
    }

    // A DELETE route that delete by book ID
    @DeleteMapping("/books/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBooksById(@PathVariable int id) {
        bookRepository.deleteById(id);
    }

    // A GET route that gets book by AuthorID
    @GetMapping("/books/author/{id}")
    public List<Book> getBookByAuthorId(@PathVariable int id) {
        List<Book> returnedBook = bookRepository.findBookByAuthorId(id);
        return returnedBook;
    }

}
