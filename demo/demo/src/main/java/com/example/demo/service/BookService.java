package com.example.demo.service;

import com.example.demo.dto.book.BookRequest;
import com.example.demo.dto.book.BookResponse;
import com.example.demo.entity.Book;
import com.example.demo.exception.ConflictException;
import com.example.demo.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public List<BookResponse> getAllBooks() {
        log.info("Getting all books");

        return bookRepository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    public BookResponse getBookById(Long bookId) {
        log.info("Getting book by id: {}", bookId);

        Book book = findBookById(bookId);

        return toResponse(book);
    }

    public BookResponse createBook(BookRequest bookRequest) {
        log.info("Creating book: {}", bookRequest.getTitle());

        if (bookRequest.getIsbn() != null && bookRepository.existsByIsbn(bookRequest.getIsbn())) {
            throw new ConflictException("ISBN already exists");
        }

        validateQuantity(bookRequest.getTotalQuantity(), bookRequest.getAvailableQuantity());

        Book book = Book.builder()
                .categoryId(bookRequest.getCategoryId())
                .title(bookRequest.getTitle())
                .authorName(bookRequest.getAuthorName())
                .publisherName(bookRequest.getPublisherName())
                .isbn(bookRequest.getIsbn())
                .publicationYear(bookRequest.getPublicationYear())
                .description(bookRequest.getDescription())
                .totalQuantity(bookRequest.getTotalQuantity())
                .availableQuantity(bookRequest.getAvailableQuantity())
                .shelfLocation(bookRequest.getShelfLocation())
                .status(bookRequest.getStatus() != null ? bookRequest.getStatus() : "AVAILABLE")
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

        Book savedBook = bookRepository.save(book);

        log.info("Book created successfully with id: {}", savedBook.getBookId());

        return toResponse(savedBook);
    }

    public BookResponse updateBook(Long bookId, BookRequest bookRequest) {
        log.info("Updating book with id: {}", bookId);

        Book book = findBookById(bookId);

        if (bookRequest.getIsbn() != null
                && !bookRequest.getIsbn().equals(book.getIsbn())
                && bookRepository.existsByIsbn(bookRequest.getIsbn()))
        {
            throw new ConflictException("ISBN already exists");
        }

        validateQuantity(bookRequest.getTotalQuantity(), bookRequest.getAvailableQuantity());

        book.setCategoryId(bookRequest.getCategoryId());
        book.setTitle(bookRequest.getTitle());
        book.setAuthorName(bookRequest.getAuthorName());
        book.setPublisherName(bookRequest.getPublisherName());
        book.setIsbn(bookRequest.getIsbn());
        book.setPublicationYear(bookRequest.getPublicationYear());
        book.setDescription(bookRequest.getDescription());
        book.setTotalQuantity(bookRequest.getTotalQuantity());
        book.setAvailableQuantity(bookRequest.getAvailableQuantity());
        book.setShelfLocation(bookRequest.getShelfLocation());
        book.setStatus(bookRequest.getStatus() != null ? bookRequest.getStatus() : book.getStatus());

        Book updatedBook = bookRepository.save(book);

        log.info("Book updated successfully with id: {}", updatedBook.getBookId());

        return toResponse(updatedBook);
    }

    public void deleteBook(Long bookId) {
        log.info("Deleting book with id: {}", bookId);

        Book book = findBookById(bookId);
        bookRepository.delete(book);

        log.info("Book deleted successfully with id: {}", book.getBookId());
    }

    private Book findBookById(Long bookId) {
        return bookRepository.findById(bookId)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Book not found with id: " + bookId
                ));
    }

    private void validateQuantity(Integer totalQuantity, Integer availableQuantity) {
        if (totalQuantity < availableQuantity) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Total quantity cannot be less than available quantity"
            );
        }
    }

    private BookResponse toResponse(Book book) {
        return BookResponse.builder()
                .bookId(book.getBookId())
                .categoryId(book.getCategoryId())
                .title(book.getTitle())
                .authorName(book.getAuthorName())
                .publisherName(book.getPublisherName())
                .isbn(book.getIsbn())
                .publicationYear(book.getPublicationYear())
                .description(book.getDescription())
                .totalQuantity(book.getTotalQuantity())
                .availableQuantity(book.getAvailableQuantity())
                .shelfLocation(book.getShelfLocation())
                .status(book.getStatus())
                .createdAt(book.getCreatedAt())
                .updatedAt(book.getUpdatedAt())
                .build();
    }
}
