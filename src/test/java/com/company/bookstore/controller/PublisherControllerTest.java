package com.company.bookstore.controller;


import com.company.bookstore.model.Publisher;
import com.company.bookstore.repository.PublisherRepository;
import org.junit.jupiter.api.Test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.http.MediaType;

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@WebMvcTest(PublisherController.class)
public class PublisherControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PublisherRepository repo;

    // ObjectMapper used to convert Java objects to JSON and vice versa


    private ObjectMapper mapper = new ObjectMapper();
    // A list of customers for testing purposes

    @BeforeEach
    public void setUp() throws Exception {
        Publisher pub = new Publisher();
        pub.setName("Elza iNC");
        pub.setStreet("123 Will Way");
        pub.setCity("Atlanta");
        pub.setState("GA");
        pub.setPostalCode("99999");pub.setEmail("elza@gmail.com");
        pub.setPhone("404-444-4444");



        // Convert Java Object to JSON
        String inputJson = mapper.writeValueAsString(pub);

        Publisher pub_o = new Publisher();
        pub_o.setName("lza Inc");
        pub_o.setStreet("123 Ill Way");
        pub_o.setCity("Atlanta");
        pub_o.setState("GA");
        pub_o.setPostalCode("99999");pub.setEmail("lza@gmail.com");
        pub_o.setPhone("404-424-4444");


        String outputJson = mapper.writeValueAsString(pub_o);

    }


    private List<Publisher> publisherList;
    @Test
    public void shouldReturnAllPublishersInCollection() throws Exception {
        String outputJson = mapper.writeValueAsString(publisherList);

        // ACT
        mockMvc.perform(get("/publishers"))                // Perform the GET request
                .andDo(print())                          // Print results to console
                .andExpect(status().isOk());              // ASSERT (status code is 200)
    }


    @Test
    public void shouldReturnPublisherbyId() throws Exception {
        String outputJson = mapper.writeValueAsString(publisherList);
        mockMvc
                .perform(get("/publishers/1"))
                .andDo(print()).andExpect(status().isOk());

    }

    @Test
    public void shouldCreatePublisher() throws Exception {
        Publisher pub = new Publisher();
        pub.setName("Jimo Inc");
        pub.setStreet("123 Jill Way");
        pub.setCity("Atlanta");
        pub.setState("GA");
        pub.setPostalCode("99999");
        pub.setEmail("jim@gmail.com");
        pub.setPhone("404-414-4444");

        // Convert Java Object to JSON
        String inputJson = mapper.writeValueAsString(pub);

        Publisher pub_o = new Publisher();
        pub.setName("Jilo Inc");
        pub.setStreet("123 Jill Way");
        pub.setCity("Atlanta");
        pub.setState("GA");
        pub.setPostalCode("99999");pub.setEmail("jil@gmail.com");
        pub.setPhone("404-434-4444");

        String outputJson = mapper.writeValueAsString(pub_o);
        mockMvc.perform(
                        post("/publishers")                            // Perform the POST request
                                .content(inputJson)                       // Set the request body
                                .contentType(MediaType.APPLICATION_JSON)  // Tell the server it's in JSON format
                )
                .andDo(print())                                // Print results to console
                .andExpect(status().isCreated());
    }

    @Test
    public void shouldUpdateExistingCustomer() throws Exception {
        Publisher pub = new Publisher();
        pub.setName("Elza iNC");
        pub.setStreet("123 Will Way");
        pub.setCity("Atlanta");
        pub.setState("GA");
        pub.setPostalCode("99899");
        pub.setEmail("elza@gmail.com");
        pub.setPhone("404-444-4444");



        // Convert Java Object to JSON
        String inputJson = mapper.writeValueAsString(pub);

        Publisher pub_o = new Publisher();
        pub_o.setName("lza Inc");
        pub_o.setStreet("123 Ill Way");
        pub_o.setCity("Atlanta");
        pub_o.setState("GA");
        pub_o.setPostalCode("99999");
        pub_o.setEmail("lza@gmail.com");
        pub_o.setPhone("404-424-4444");
        pub_o.setId(1);



        String outputJson = mapper.writeValueAsString(pub_o);

        mockMvc.perform(
                        put("/publishers/1")                            // Perform the PUT request
                                .content(inputJson)                       // Set the request body
                                .contentType(MediaType.APPLICATION_JSON)  // Tell the server it's in JSON format
                )
                .andDo(print())                                // Print results to console
                .andExpect(status().isNoContent());
    }

    @Test
    public void shouldDeletePublisher() throws Exception {
        String outputJson = mapper.writeValueAsString(publisherList);
        mockMvc.perform(delete("/publishers/1")).andDo(print()).andExpect(status().isNoContent());

    }






}

