package com.example.Booklist.controller;

import com.example.Booklist.dto.BookDTO;
import com.example.Booklist.model.Book;
import com.example.Booklist.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class BookController {
    @Autowired
    BookService bookService;

    @PostMapping("/books")
    public ResponseEntity<Book> createBook(@Valid @RequestBody Book book){
        return ResponseEntity.ok(bookService.createBook(book));
    }

    @GetMapping("/books")
    public List<BookDTO> readBooks(){ return bookService.getAllBooks();}

    @GetMapping("/books/{bookId}")
    public BookDTO readBook(@PathVariable(value = "bookId") Integer id){
        return bookService.getBook(id);
    }

    @PutMapping("/books/{bookId}")
    public Book updateBook(@PathVariable(value = "bookId") Integer id, @RequestBody Book bookData){
        return bookService.updateBook(id, bookData);
    }

    @DeleteMapping("/books/{bookId}")
    public void deleteBook(@PathVariable(value = "bookId") Integer id){
        bookService.deleteBook(id);
    }
}
