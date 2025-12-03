package com.eduard.librarymanagementproject.service.LoanBook;

import com.eduard.librarymanagementproject.model.entity.Book;

public interface LoanBookService {

    Book loanBook(Book book);

    Book returnBook(Long bookId);


}
