package com.example.Booklist.service;

import com.example.Booklist.dto.BookDTO;
import com.example.Booklist.model.Book;
import com.example.Booklist.repository.BookRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;

    @Autowired
    private ModelMapper mapper;

    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    public List<BookDTO> getAllBooks() {
        return bookRepository.findAll().stream().map(book -> mapper.map(book, BookDTO.class)).toList();
    }

    public BookDTO getBook(Integer id) {
        BookDTO book = bookRepository.findById(id).map(book1 -> mapper.map(book1, BookDTO.class))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return book;
    }

    public Book updateBook(Integer id, Book bookData){
        Book book = bookRepository.findById(id).get();
        book.setTitle(bookData.getTitle());
        book.setPages(bookData.getPages());
        return bookRepository.save(book);
    }

    public void deleteBook(Integer id){
        bookRepository.deleteById(id);
    }
}
