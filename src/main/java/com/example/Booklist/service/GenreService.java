package com.example.Booklist.service;

import com.example.Booklist.dto.BookDTO;
import com.example.Booklist.repository.GenreRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreService {
    @Autowired
    GenreRepository genreRepository;

    @Autowired
    private ModelMapper mapper;

    public List<BookDTO> getBooksByGenreId(Integer id){
        return genreRepository.findBooksById(id).stream().map(book -> mapper.map(book, BookDTO.class))
                .toList();
    }
}
