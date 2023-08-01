package com.company.bookstore.repository;

import com.company.bookstore.model.Book;
import com.company.bookstore.model.Publisher;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
public class BookRepositoryTest {

    @Autowired
    BookRepository bookRepository;
    
    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    PublisherRepository publisherRepository;
    
    private Date date;

    @BeforeEach
    public void setUp() throws Exception {
        bookRepository.deleteAll();
        authorRepository.deleteAll();
        publisherRepository.deleteAll();
    }

    //Test Create
    @Test
    public void addBook() {
        date = new Date();
        Book book = new Book();
        book.setIsbn("1235");
        book.setTitle("Green");
        book.setPublish_date(date);
        book.setAuthor_id(2);
        book.setPrice(12.99);
        book.setId(1);


        book = bookRepository.save(book);

        Optional<Book> book1 = bookRepository.findById(book.getId());
        assertEquals(book1.get(), book);


    }

    //Test Read by ID
    @Test
    public void getBookById() {
        date = new Date();
        Book book = new Book();
        book.setIsbn("1235");
        book.setTitle("Green");
        book.setPublish_date(date);
        book.setAuthor_id(2);
        book.setPrice(12.99);
        book.setId(1);

        book = bookRepository.save(book);

        Optional<Book> book1 = bookRepository.findById(book.getId());

        assertEquals(book1.get(), book);

    }

    // Test Read All
    @Test
    public void getAllBooks() {
        date = new Date();
        Book book = new Book();
        book.setIsbn("1235");
        book.setTitle("Green");
        book.setPublish_date(date);
        book.setAuthor_id(2);
        book.setPrice(12.99);
        book.setId(1);

        date = new Date();
        Book book2 = new Book();
        book2.setIsbn("1235");
        book2.setTitle("Green");
        book2.setPublish_date(date);
        book2.setAuthor_id(2);
        book2.setPrice(12.99);
        book2.setId(2);

        List<Book> bookList = bookRepository.findAll();
        assertEquals(2, bookList.size());
    }

    // Test Update
    @Test
    public void updateBook() {
        date = new Date();
        Book book = new Book();
        book.setIsbn("1235");
        book.setTitle("Green");
        book.setPublish_date(date);
        book.setAuthor_id(2);
        book.setPrice(12.99);
        book.setId(1);
        bookRepository.save(book);

        book.setTitle("Blue");

        bookRepository.save(book);

        Optional<Book> book1 = bookRepository.findById(book.getId());

        assertEquals(book1.get(), book);
    }


    // Test Delete
    @Test
    public void deleteBook() {
        date = new Date();
        Book book = new Book();
        book.setIsbn("1235");
        book.setTitle("Green");
        book.setPublish_date(date);
        book.setAuthor_id(2);
        book.setPrice(12.99);
        book.setId(1);
        bookRepository.save(book);

        bookRepository.deleteById(book.getId());

        Optional<Book> book1 = bookRepository.findById(book.getId());
        assertFalse(book1.isPresent());
    }

    // Test Get Book by Author ID
    @Test
    public void getBookByAuthorId() {
        date = new Date();
        Book book = new Book();
        book.setIsbn("1235");
        book.setTitle("Green");
        book.setPublish_date(date);
        book.setAuthor_id(2);
        book.setPrice(12.99);
        book.setId(1);
        bookRepository.save(book);

        Optional<Book> book1 = bookRepository.findById(book.getAuthor_id());

        assertEquals(book1.get(), book);

    }

}
