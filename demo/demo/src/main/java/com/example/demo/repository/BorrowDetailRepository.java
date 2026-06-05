package com.example.demo.repository;

import com.example.demo.entity.BorrowDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BorrowDetailRepository extends JpaRepository<BorrowDetails, Long> {
}
