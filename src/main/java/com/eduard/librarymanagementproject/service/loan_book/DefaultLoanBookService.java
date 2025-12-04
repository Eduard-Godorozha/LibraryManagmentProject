package com.eduard.librarymanagementproject.service.loan_book;

import com.eduard.librarymanagementproject.model.BookStatus;
import com.eduard.librarymanagementproject.model.entity.Book;
import com.eduard.librarymanagementproject.model.entity.LoanBook;
import com.eduard.librarymanagementproject.model.entity.Reader;
import com.eduard.librarymanagementproject.repository.BookRepository;
import com.eduard.librarymanagementproject.repository.LoanBookRepository;
import com.eduard.librarymanagementproject.repository.ReaderRepository;
import com.eduard.librarymanagementproject.service.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DefaultLoanBookService implements LoanBookService {

    private final LoanBookRepository loanBookRepository;

    private final ReaderRepository readerRepository;

    private final BookRepository bookRepository;

    @Override
    public LoanBook loanBook(Long readerId, Long bookId, LocalDateTime dueDate) {
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found"));

        Reader reader = readerRepository.findById(readerId)
                .orElseThrow(() -> new ResourceNotFoundException("Reader not found"));

        if (book.getNumberOfCopies() == 0){
            throw new ResourceNotFoundException("No copies available for this book");
        }

        int remainingCopies = book.getNumberOfCopies() - 1;
        book.setNumberOfCopies(remainingCopies);
        book.setStatus(remainingCopies > 0 ? BookStatus.AVAILABLE : BookStatus.ISSUED);

        bookRepository.save(book);

        LoanBook loanBook = new LoanBook();
        loanBook.setBook(book);
        loanBook.setReader(reader);
        loanBook.setDueDate(dueDate);
        loanBook.setIssueDate(LocalDateTime.now());
        return loanBookRepository.save(loanBook);
    }

    @Override
    public LoanBook returnBook(Long loanId) {
        LoanBook loan = loanBookRepository.findById(loanId)
                .orElseThrow(() -> new RuntimeException("Loan not found"));

        if (loan.getReturnDate() != null){
            throw new RuntimeException("Book already returned");
        }
        loan.setReturnDate(LocalDateTime.now());

        Book book = loan.getBook();
        book.setNumberOfCopies(book.getNumberOfCopies() + 1);
        book.setStatus(BookStatus.AVAILABLE);
        bookRepository.save(book);

        return loanBookRepository.save(loan);
    }

    @Override
    public List<LoanBook> getHistoryOfIssuedBooks(Long readerId) {
        return loanBookRepository.findByReaderId(readerId);
    }

    @Override
    public List<Reader> getDebtors() {
        List<LoanBook> overdueLoans = loanBookRepository
                .findByReturnDateIsNullAndDueDateBefore(LocalDateTime.now());

        return overdueLoans.stream()
                .map(LoanBook::getReader)
                .distinct()
                .toList();
    }
}
