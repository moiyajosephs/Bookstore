package com.company.bookstore.controller;

import com.company.bookstore.model.Book;
import com.company.bookstore.repository.BookRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;
    private ObjectMapper mapper =  new ObjectMapper();
    private List<Book> bookList;

    @MockBean
    private BookRepository bookRepository;

    // Testing POST /books/
    @Test
    public void shouldReturnBookonPostRequest() {

        Book book = new Book();
        book.setIsbn("1235");
        book.setTitle();
        book.setPublish_date();
        book.setAuthor_id();
        book.setPrice();

        String inputJson = mapper.writeValueAsString(book);



    }

    // Testing GET /books/{id}
    @Test
    public void shouldReturnBookbyIdonGetRequest() {
    }

    // Testing GET /books/
    @Test
    public void shouldReturnAllBooksonGetRequest() {
    }

    // Testing PUT /books
    @Test
    public void shouldUpdateBookonPostRequest() {
    }

    // Testing DELETE /books/{id}
    @Test
    public void shouldDeleteBookByIdonDeletePostRequest() {
    }

    // Testing GET /books/author/{id}
    @Test
    public void getBookByAuthorIdonGetRequest() {

    }
}