package com.example.demo.dto.book;

import lombok.Builder;
import lombok.Value;

import java.time.LocalDateTime;

@Value
@Builder
public class BookResponse {

    Long bookId;
    Long categoryId;
    String title;
    String authorName;
    String publisherName;
    String isbn;
    Integer publicationYear;
    String description;
    Integer totalQuantity;
    Integer availableQuantity;
    String shelfLocation;
    String status;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
}