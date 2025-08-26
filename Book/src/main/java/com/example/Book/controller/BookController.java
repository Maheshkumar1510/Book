package com.example.Book.controller;

import com.example.Book.dto.BookDto;
import com.example.Book.entity.BookEntity;
import com.example.Book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//GET /api/books: Retrieve a list of all books.
//GET /api/books/{id}: Retrieve a specific book by ID.
//POST /api/books: Create a new book (requires a JSON body with title, author, publishedYear, and genre).
//PUT /api/books/{id}: Update an existing book by ID (requires a JSON body with updated fields).
//DELETE /api/books/{id}: Delete a book by ID.
@RestController
public class BookController {
    @Autowired
    BookService bookService;
    @PostMapping("/api/books")
    public ResponseEntity<BookDto> create (BookDto bookDto){
       return bookService.create(bookDto);
    }

    @GetMapping("/api/books")
    public ResponseEntity<List<BookEntity>> getAll(){
        return bookService.getAll();
    }

    @GetMapping("/api/books/{id}")
    public ResponseEntity<Optional<BookEntity>> getById(@PathVariable Long id){
        return bookService.getById(id);
    }
   @PutMapping("/api/books/{id}")
    public ResponseEntity<BookEntity> updateById(@PathVariable Long id, BookDto bookDto ){
        return bookService.updateById(id,bookDto);
   }
    @DeleteMapping("/api/books/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        return bookService.deleteById(id);
    }


}
