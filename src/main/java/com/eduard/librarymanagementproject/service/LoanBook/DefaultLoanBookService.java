package com.eduard.librarymanagementproject.service.LoanBook;

import com.eduard.librarymanagementproject.model.entity.Book;
import com.eduard.librarymanagementproject.service.book.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DefaultLoanBookService implements LoanBookService {

    @Override
    public Book loanBook(Book book) {
        return null;
    }

    @Override
    public Book returnBook(Long bookId) {
        return null;
    }
}
