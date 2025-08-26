package com.example.Book.dto;


import lombok.Data;

@Data
//id (Long): The unique identifier for the book (auto-generated).
//title (String): The title of the book.
//author (String): The author of the book.
//publishedYear (Integer): The year the book was published.
//genre (String): The genre of the book.
public class BookDto {
    Long id;
    String title;
    String author;
    Integer publishedYear;
    String genre;
}
