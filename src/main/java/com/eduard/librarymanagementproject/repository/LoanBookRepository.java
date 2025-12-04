package com.eduard.librarymanagementproject.repository;

import com.eduard.librarymanagementproject.model.entity.LoanBook;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public interface LoanBookRepository extends JpaRepository<LoanBook, Long> {

    List<LoanBook> findByReaderId(Long readerId);

    List<LoanBook> findByReturnDateIsNullAndDueDateBefore(LocalDateTime time);

}
