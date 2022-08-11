package com.example.Booklist.repository;

import com.example.Booklist.model.ReadingList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReadingListRepository extends JpaRepository<ReadingList, Integer> {
    List<ReadingList> findAllByBookUserId(int bookUserId);
}
