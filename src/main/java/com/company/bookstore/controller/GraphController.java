package com.company.bookstore.controller;


import com.company.bookstore.model.Book;
import com.company.bookstore.repository.AuthorRepository;
import com.company.bookstore.repository.BookRepository;
import com.company.bookstore.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class GraphController {

    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    BookRepository bookRepository;

    @Autowired
    PublisherRepository publisherRepository;

    // Book

    @QueryMapping
    public List<Book> books() {
        return bookRepository.findAll();
    }

    @QueryMapping
    public Book findBookById(@Argument int id){
        Optional<Book> returnBook = bookRepository.findById(id);
        if (returnBook.isPresent()){
            return returnBook.get();
        } else {
            return null;
        }
    }




}
