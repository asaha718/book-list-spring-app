package com.example.Booklist.repository;

import com.example.Booklist.model.Book;
import com.example.Booklist.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Integer> {
    List<Book> findBooksById(Integer id);
}
