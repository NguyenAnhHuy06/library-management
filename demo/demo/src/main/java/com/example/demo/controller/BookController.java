package com.example.demo.controller;

import com.example.demo.dto.ApiResponse;
import com.example.demo.dto.book.BookRequest;
import com.example.demo.dto.book.BookResponse;
import com.example.demo.service.BookService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${api.prefix}/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<BookResponse>> createBook(
            @Valid @RequestBody BookRequest bookRequest
    ) {
        BookResponse bookResponse = bookService.createBook(bookRequest);

        return ResponseEntity.ok(
                ApiResponse.<BookResponse>builder()
                        .success(true)
                        .message("Create book successfully")
                        .data(bookResponse)
                        .build()
        );
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<BookResponse>>> getAllBooks() {
        List<BookResponse> response = bookService.getAllBooks();

        return ResponseEntity.ok(
                ApiResponse.<List<BookResponse>>builder()
                        .success(true)
                        .message("Get books successfully")
                        .data(response)
                        .build()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<BookResponse>> getBookById(
            @PathVariable("id") Long bookId
    ) {
        BookResponse bookResponse = bookService.getBookById(bookId);

        return ResponseEntity.ok(
                ApiResponse.<BookResponse>builder()
                        .success(true)
                        .message("Get book successfully")
                        .data(bookResponse)
                        .build()
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<BookResponse>> updateBook(
            @PathVariable("id") Long bookId,
            @Valid @RequestBody BookRequest bookRequest
    ) {
        BookResponse bookResponse = bookService.updateBook(bookId, bookRequest);

        return ResponseEntity.ok(
                ApiResponse.<BookResponse>builder()
                        .success(true)
                        .message("Update book successfully")
                        .data(bookResponse)
                        .build()
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteBook(
            @PathVariable("id") Long bookId
    ) {
        bookService.deleteBook(bookId);

        return ResponseEntity.ok(
                ApiResponse.<Void>builder()
                        .success(true)
                        .message("Delete book successfully")
                        .build()
        );
    }
}