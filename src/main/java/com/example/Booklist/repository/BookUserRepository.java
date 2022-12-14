package com.example.Booklist.repository;

import com.example.Booklist.model.BookUser;
import com.example.Booklist.model.ReadingList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookUserRepository extends JpaRepository<BookUser, Integer> {

}
