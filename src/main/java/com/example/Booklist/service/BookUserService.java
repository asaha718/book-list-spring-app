package com.example.Booklist.service;

import com.example.Booklist.dto.UserDTO;
import com.example.Booklist.dto.UsersReadingListDTO;
import com.example.Booklist.model.BookUser;
import com.example.Booklist.model.ReadingList;
import com.example.Booklist.repository.BookUserRepository;
import com.example.Booklist.repository.ReadingListRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class BookUserService {
    @Autowired
    BookUserRepository userRepository;

    @Autowired
    ReadingListRepository readingListRepository;

    @Autowired
    private ModelMapper mapper;

    //Create user
    public UserDTO createUser(BookUser user) {
        return mapper.map(userRepository.save(user), UserDTO.class);
    }

    //Delete user
    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }

    //Gets the users readinglists
    public List<UsersReadingListDTO> getReadingLists(Integer id) {
        List<ReadingList> readingListsForUser = readingListRepository.findAllByBookUserId(id);
        return readingListsForUser.stream().map(readingList -> mapper.map(readingList, UsersReadingListDTO.class))
                .toList();
    }
    //Creates a new readingList for user

    public BookUser createReadingListForUser(Integer id) {
        BookUser user = userRepository.findById(id).get();
        user.getReadingLists().add(new ReadingList());
        return user;
    }

    public ReadingList getUsersReadingList( Integer readingListId, Integer userId ){
        return readingListRepository.findByIdAndBookUserId(readingListId, userId);
    }
}
