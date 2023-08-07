package com.company.bookstore.controller;


import com.company.bookstore.model.Author;
import com.company.bookstore.model.Book;
import com.company.bookstore.model.Publisher;
import com.company.bookstore.repository.AuthorRepository;
import com.company.bookstore.repository.BookRepository;
import com.company.bookstore.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
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


    // Get a book by id.
    //Including the author and publisher of the book.
    @QueryMapping
    public Book findBookById(@Argument int id){
        Optional<Book> returnBook = bookRepository.findById(id);
        if (returnBook.isPresent()){
            return returnBook.get();
        } else {
            return null;
        }
    }

    @SchemaMapping
    public Author author (Book book) {
        Optional<Author> returnVal = authorRepository.findById(book.getAuthorId());
        if (returnVal.isPresent()) {
            return returnVal.get();
        } else {
            return null;
        }

    }

    @SchemaMapping
    public Publisher publisher (Book book) {
        Optional<Publisher> returnVal = publisherRepository.findById(book.getPublisherId());
        if (returnVal.isPresent()) {
            return returnVal.get();
        } else {
            return null;
        }
    }

    //get publisher by id
    @QueryMapping
    public Publisher getPublisherbyId(@Argument int id) {
        Optional<Publisher> returnval = publisherRepository.findById(id);
        if (returnval.isPresent()) {
            return returnval.get();
        } else {
            return null;
        }
    }
    




}
