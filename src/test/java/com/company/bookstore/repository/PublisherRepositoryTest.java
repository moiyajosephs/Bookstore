package com.company.bookstore.repository;

import com.company.bookstore.model.Publisher;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
public class PublisherRepositoryTest {
    @Autowired
    AuthorRepository authorRepository;
    @Autowired
    BookRepository bookRepository;

    @Autowired
    PublisherRepository publisherRepository;

    @BeforeEach
    public void setUp() throws Exception {

        authorRepository.deleteAll();
        bookRepository.deleteAll();
        publisherRepository.deleteAll();
    }

    @Test
    public void shouldAddPublisher() {
        Publisher pub = new Publisher();
        pub.setName("Elza iNC");
        pub.setStreet("123 Will Way");
        pub.setCity("Atlanta");
        pub.setState("GA");
        pub.setPostalCode("99999");
        pub.setEmail("elza@gmail.com");
        pub.setPhone("404-444-4444");


        //act
        pub = publisherRepository.save(pub);
        Optional<Publisher> pub1 = publisherRepository.findById(pub.getId());

        //assert
        assertEquals(pub1.get(), pub);
    }

    @Test
    public void shouldUpdatePublisher() {
        Publisher pub = new Publisher();
        pub.setName("Elza iNC");
        pub.setStreet("123 Will Way");
        pub.setCity("Atlanta");
        pub.setState("GA");
        pub.setPostalCode("99999");
        pub.setEmail("elza@gmail.com");
        pub.setPhone("404-444-4444");

        pub = publisherRepository.save(pub);

        pub.setName("Aye iNC");
        pub.setStreet("123 Will Way");
        pub.setCity("Atlanta");
        pub.setState("GA");
        pub.setPostalCode("99999");
        pub.setEmail("elza@gmail.com");
        pub.setPhone("404-444-4444");

        pub = publisherRepository.save(pub);
        //act
        Optional<Publisher> pub1 = publisherRepository.findById(pub.getId());

        //assert
        assertEquals(pub1.get(), pub);

    }

    @Test
    public void shouldGetPublisherbyId() {
        Publisher pub = new Publisher();
        pub.setName("Elza iNC");
        pub.setStreet("123 Will Way");
        pub.setCity("Atlanta");
        pub.setState("GA");
        pub.setPostalCode("99999");
        pub.setEmail("elza@gmail.com");
        pub.setPhone("404-444-4444");
        publisherRepository.save(pub);


        Publisher pub2 = new Publisher();
        pub2.setName("Laye iNC");
        pub2.setStreet("123 Will Way");
        pub2.setCity("Atlanta");
        pub2.setState("GA");
        pub2.setPostalCode("99999");
        pub2.setEmail("za@gmail.com");
        pub2.setPhone("404-111-4444");
        publisherRepository.save(pub2);

        Optional<Publisher> foundPublisher = publisherRepository.findById(pub.getId());
        assertEquals(foundPublisher.get(), pub);

    }

    @Test
    public void shouldRemovePublisher() {
        Publisher pub = new Publisher();
        pub.setName("Elza iNC");
        pub.setStreet("123 Will Way");
        pub.setCity("Atlanta");
        pub.setState("GA");
        pub.setPostalCode("99999");
        pub.setEmail("elza@gmail.com");
        pub.setPhone("404-444-4444");
        pub = publisherRepository.save(pub);

        Optional<Publisher> pub1 = publisherRepository.findById(pub.getId());
        assertEquals(pub1.get(), pub);

        publisherRepository.deleteById(pub.getId());
        pub1 = publisherRepository.findById(pub.getId());
        assertFalse(pub1.isPresent());

    }


}
