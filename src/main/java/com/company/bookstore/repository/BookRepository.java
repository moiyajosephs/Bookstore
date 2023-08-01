package com.company.bookstore.repository;

import com.company.bookstore.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {
    //Search Book by Author ID
    List<Book> findBookByAuthorId(int authorId);
}
