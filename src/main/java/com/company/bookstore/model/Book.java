package com.company.bookstore.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "Book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private int id;

    private int isbn;

    private Date publish_date;

    //One to Many , one author to many books?
    private int author_id;

    private String title;

    //One to one (?)
    private int publisher_id;

    // double or float?
    private double price;


}
