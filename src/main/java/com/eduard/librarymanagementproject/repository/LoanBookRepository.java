package com.eduard.librarymanagementproject.repository;

import com.eduard.librarymanagementproject.model.entity.LoanBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanBookRepository extends JpaRepository<LoanBook,Long> {
}
