package com.example.Book.service;

import com.example.Book.dto.BookDto;
import com.example.Book.entity.BookEntity;
import com.example.Book.repo.BookRepo;
import jakarta.transaction.Status;
import org.hibernate.sql.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    BookRepo bookRepo;

    public ResponseEntity<BookDto> create(BookDto bookDto) {
        BookEntity bookEntity = BookEntity.builder()
                .id(bookDto.getId())
                .author(bookDto.getAuthor())
                .title(bookDto.getTitle())
                .genre(bookDto.getGenre())
                .publishedYear(bookDto.getPublishedYear())
                .build();
        bookRepo.save(bookEntity);
        return ResponseEntity.ok(bookDto);
    }

    public ResponseEntity<List<BookEntity>> getAll() {
        List<BookEntity> bookEntities = bookRepo.findAll();
        return ResponseEntity.ok(bookEntities);
    }

    public ResponseEntity<Optional<BookEntity>> getById(Long id) {

        return ResponseEntity.ok(bookRepo.findById(id));
    }

    public ResponseEntity<BookEntity> updateById(Long id, BookDto bookDto) {
        Optional<BookEntity> bookEntity = bookRepo.findById(id);
        if (bookEntity.isPresent()) {
            BookEntity bookEntity1 = BookEntity.builder()
                    .id(bookDto.getId())
                    .author(bookDto.getAuthor())
                    .title(bookDto.getTitle())
                    .genre(bookDto.getGenre())
                    .publishedYear(bookDto.getPublishedYear())
                    .build();
            bookRepo.save(bookEntity1);
           return ResponseEntity.ok(bookEntity1);
        } else
            return (ResponseEntity<BookEntity>) ResponseEntity.status(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<?> deleteById(Long id) {
        bookRepo.deleteById(id);
        return (ResponseEntity<String>) ResponseEntity.ok();
    }
}
