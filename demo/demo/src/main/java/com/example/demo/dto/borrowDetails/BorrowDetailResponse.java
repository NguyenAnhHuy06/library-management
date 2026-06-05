package com.example.demo.dto.borrowDetails;

import lombok.Builder;
import lombok.Value;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Value
@Builder
public class BorrowDetailResponse {

    Long borrowDetailId;
    Long ticketId;
    Long bookId;
    Integer quantity;
    LocalDate returnDate;
    String status;
    BigDecimal fineAmount;
    String fineReason;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
}
