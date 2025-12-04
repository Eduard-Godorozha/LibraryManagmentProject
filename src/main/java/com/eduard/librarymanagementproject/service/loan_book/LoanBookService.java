package com.eduard.librarymanagementproject.service.loan_book;

import com.eduard.librarymanagementproject.model.entity.LoanBook;
import com.eduard.librarymanagementproject.model.entity.Reader;

import java.time.LocalDateTime;
import java.util.List;

public interface LoanBookService {

    LoanBook loanBook(Long readerId, Long bookId, LocalDateTime dueDate);

    LoanBook returnBook(Long loanId);

    List<LoanBook> getHistoryOfIssuedBooks(Long readerId);

    List<Reader> getDebtors();


}
