package com.company.bookstore.repository;

import com.company.bookstore.model.Author;
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
public class AuthorRepositoryTest {
    @Autowired
    BookRepository bookRepository;
    @Autowired
    AuthorRepository authorRepository;
    @Autowired
    PublisherRepository publisherRepository;
    private Date date;
    private Author author;

    private Author author2;

    @BeforeEach
    public void setUp() throws Exception {
        authorRepository.deleteAll();
        publisherRepository.deleteAll();
        bookRepository.deleteAll();

        author = new Author();
        author.setFirstName("John");
        author.setLastName("Doe");
        author.setStreet("1st St");
        author.setPostalCode(11111);
        author.setPhoneNumber("435-244-1238");
        author.setCity("New York City");
        author.setState("");
        author.setEmail("john@gmail");

        authorRepository.save(author);
        author2 = new Author();
        author2.setFirstName("John");
        author2.setLastName("Doe");
        author2.setStreet("1st St");
        author2.setPostalCode(11111);
        author2.setPhoneNumber("435-244-1238");
        author2.setCity("New York City");
        author2.setState("");
        author2.setEmail("john@gmail");

        authorRepository.save(author2);
    }

    @Test
    public void addAuthor() {


        Optional author1 = authorRepository.findById(author.getId());
        assertEquals(author1.get(), author);
    }

    @Test
    public void getAuthorById() {

        Optional author1 = authorRepository.findById(author.getId());
        assertEquals(author1.get(), author);
    }

    @Test
    public void getAllAuthors() {
        List<Author> authors = authorRepository.findAll();
        assertEquals(authors.size(), 2);
    }

    @Test
    public void updateAuthor() {
        author.setLastName("Joe");
        authorRepository.save(author);

        Optional author1 = authorRepository.findById(author.getId());
        assertEquals(author1.get(), author);
    }

    @Test
    public void deleteAuthor() {
        authorRepository.deleteById(author.getId());

        Optional author1 = authorRepository.findById(author.getId());
        assertFalse(author1.isPresent());
    }

}
