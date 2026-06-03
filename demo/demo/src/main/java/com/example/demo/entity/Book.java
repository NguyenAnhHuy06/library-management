package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "books")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Long bookId;

    @Column(name = "category_id", nullable = false)
    private Long categoryId;

    @Column(name = "title", nullable = false, length = 200)
    private String title;

    @Column(name = "author_name", length = 100)
    private String authorName;

    @Column(name = "publisher_name", length = 150)
    private String publisherName;

    @Column(name = "isbn", unique = true, length = 50)
    private String isbn;

    @Column(name = "publication_year")
    private Integer publicationYear;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "total_quantity", nullable = false)
    private Integer totalQuantity;

    @Column(name = "available_quantity", nullable = false)
    private Integer availableQuantity;

    @Column(name = "shelf_location", length = 100)
    private String shelfLocation;

    @Column(name = "status", nullable = false, length = 30)
    private String status;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}