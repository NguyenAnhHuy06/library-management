package com.example.demo.dto.book;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookRequest {

    @NotNull(message = "Category ID is required")
    private Long categoryId;

    @NotBlank(message = "Title is required")
    private String title;

    private String authorName;

    private String publisherName;

    private String isbn;

    private Integer publicationYear;

    private String description;

    @NotNull(message = "Total quantity is required")
    @Min(value = 0, message = "Total quantity must be greater than or equal to 0")
    private Integer totalQuantity;

    @NotNull(message = "Available quantity is required")
    @Min(value = 0, message = "Available quantity must be greater than or equal to 0")
    private Integer availableQuantity;

    private String shelfLocation;

    private String status;
}
