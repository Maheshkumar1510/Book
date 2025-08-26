package com.example.Book.entity;

import jakarta.persistence.GeneratedValue;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import org.springframework.data.annotation.Id;
@Data
@Builder
public class BookEntity {

    @Id
    @GeneratedValue()
    Long id;
    String title;
    String author;
    Integer publishedYear;
    String genre;
}
