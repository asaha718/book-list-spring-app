package com.example.Booklist.controller;

import com.example.Booklist.dto.BookDTO;
import com.example.Booklist.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class GenreController {
    @Autowired
    GenreService genreService;

    @GetMapping("/genre/{id}/books")
    public List<BookDTO> readAllBooksByGenre(@PathVariable(value = "id")Integer id){
        return genreService.getBooksByGenreId(id);
    }
}
