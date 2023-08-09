package com.company.bookstore.repository;

import com.company.bookstore.model.Author;
import com.company.bookstore.model.Book;
import com.company.bookstore.model.Publisher;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

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

    private LocalDate date;

    private Author author;

    private Publisher pub;

    private final Set<Book> books = new HashSet<>();

    @BeforeEach
    public void setUp() throws Exception {
        bookRepository.deleteAll();
        authorRepository.deleteAll();
        publisherRepository.deleteAll();
        date = LocalDate.of(2023, 2, 21);

        pub = new Publisher();
        pub.setName("Elza iNC");
        pub.setStreet("123 Will Way");
        pub.setCity("Atlanta");
        pub.setState("GA");
        pub.setPostalCode("99999");
        pub.setEmail("elza@gmail.com");
        pub.setPhone("404-444-4444");

        author = new Author();
        author.setFirstName("");
        author.setLastName("");
        author.setStreet("");
        author.setCity("");
        author.setPhoneNumber("elza@gmail.com");
        author.setPostalCode(9999);
        author.setEmail("eoem");
        author.setBooks(books);
        author.setState("");


        authorRepository.save(author);
        publisherRepository.save(pub);

    }

    //Test Create
    @Test
    public void addBook() {
        Book book = new Book();

        book.setIsbn("1235");
        book.setTitle("Green");
        book.setPublishDate(LocalDate.of(2023, 2, 21));
        book.setAuthorId(author.getId());
        book.setPrice(12.99);
        book.setPublisherId(pub.getId());


        bookRepository.save(book);

        Optional<Book> book1 = bookRepository.findById(book.getId());
        assertEquals(book1.get(), book);


    }

    //Test Read by ID
    @Test
    public void getBookById() {

        Book book = new Book();
        book.setIsbn("1235");
        book.setTitle("Green");
        book.setPublishDate(date);
        book.setAuthorId(author.getId());
        book.setPublisherId(pub.getId());
        book.setPrice(12.99);


        bookRepository.save(book);

        Optional<Book> book1 = bookRepository.findById(book.getId());

        assertEquals(book1.get(), book);

    }

    // Test Read All
    @Test
    public void getAllBooks() {

        Book book = new Book();
        book.setIsbn("1235");
        book.setTitle("Green");
        book.setPublishDate(date);
        book.setAuthorId(author.getId());
        book.setPublisherId(pub.getId());
        book.setPrice(12.99);
        bookRepository.save(book);


        Book book2 = new Book();
        book2.setIsbn("1235");
        book2.setTitle("Green");
        book2.setPublishDate(date);
        book2.setAuthorId(author.getId());
        book2.setPublisherId(pub.getId());
        book2.setPrice(12.99);
        bookRepository.save(book2);

        List<Book> bookList = bookRepository.findAll();
        assertEquals(2, bookList.size());
    }

    // Test Update
    @Test
    public void updateBook() {

        Book book = new Book();
        book.setIsbn("1235");
        book.setTitle("Green");
        book.setPublishDate(date);
        book.setAuthorId(author.getId());
        book.setPublisherId(pub.getId());
        book.setPrice(12.99);

        bookRepository.save(book);

        book.setTitle("Blue");

        bookRepository.save(book);

        Optional<Book> book1 = bookRepository.findById(book.getId());

        assertEquals(book1.get(), book);
    }


    // Test Delete
    @Test
    public void deleteBook() {

        Book book = new Book();
        book.setIsbn("1235");
        book.setTitle("Green");
        book.setPublishDate(date);
        book.setAuthorId(author.getId());
        book.setPublisherId(pub.getId());
        book.setPrice(12.99);

        bookRepository.save(book);

        bookRepository.deleteById(book.getId());

        Optional<Book> book1 = bookRepository.findById(book.getId());
        assertFalse(book1.isPresent());
    }

    // Test Get Book by Author ID
    @Test
    public void getBookByAuthorId() {

        Book book = new Book();
        book.setIsbn("1235");
        book.setTitle("Green");
        book.setPublishDate(date);
        book.setAuthorId(author.getId());
        book.setPublisherId(pub.getId());
        book.setPrice(12.99);

        bookRepository.save(book);

        List<Book> book1 = bookRepository.findBookByAuthorId(book.getAuthorId());

        assertEquals(1, book1.size());

    }

}
