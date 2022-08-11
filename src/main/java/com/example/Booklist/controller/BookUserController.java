package com.example.Booklist.controller;

import com.example.Booklist.dto.UserDTO;
import com.example.Booklist.dto.UsersReadingListDTO;
import com.example.Booklist.model.BookUser;
import com.example.Booklist.model.ReadingList;
import com.example.Booklist.service.BookUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class BookUserController {
    @Autowired
    BookUserService userService;

    @PostMapping("/users")
    public ResponseEntity<UserDTO> createUser(@Valid @RequestBody BookUser user){
        return ResponseEntity.ok(userService.createUser(user));
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable(value = "id") Integer id) {
        userService.deleteUser(id);
    }

    @GetMapping("/users/{id}/reading_lists")
    public List<UsersReadingListDTO> getUsersReadingList(@PathVariable(value = "id") Integer id){
        return userService.getReadingLists(id);
    }

    @PostMapping("/users/{id}/reading_lists")
    public BookUser createReadingList (@PathVariable(value = "id") Integer id) {
        return userService.createReadingListForUser(id);
    }

    @GetMapping("/users/{id}/reading_lists/{list_id}")
    public ReadingList getReadingListFromUser(@PathVariable(value = "id") Integer id, @PathVariable(value = "list_id") Integer list_id){
        return userService.getUsersReadingList(id, list_id);
    }
}

