package com.eduard.librarymanagementproject.web.controller;

import com.eduard.librarymanagementproject.model.entity.LoanBook;
import com.eduard.librarymanagementproject.model.entity.Reader;
import com.eduard.librarymanagementproject.service.loan_book.LoanBookService;
import com.eduard.librarymanagementproject.web.dto.LoanBookDto;
import com.eduard.librarymanagementproject.web.dto.ReaderDto;
import com.eduard.librarymanagementproject.web.mapper.LoanBookMapper;
import com.eduard.librarymanagementproject.web.mapper.ReaderMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/loans")
@RequiredArgsConstructor
public class LoanBookController {

    private final LoanBookService loanBookService;

    private final LoanBookMapper loanBookMapper;

    private final ReaderMapper readerMapper;

    @PutMapping("/{id}/return")
    public LoanBookDto returnBook(@PathVariable Long id){
        return loanBookMapper.toDto(loanBookService.returnBook(id));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public LoanBookDto issueBook(@Valid @RequestBody LoanBookDto loanBookDto){
        LoanBook saved = loanBookService.loanBook(
                loanBookDto.getReader().getId(),
                loanBookDto.getBook().getId(),
                loanBookDto.getDueDate());
        return loanBookMapper.toDto(saved);
    }

    @GetMapping("/reader/{id}")
    public List<LoanBookDto> getReaderHistory(@PathVariable Long id){
        List<LoanBook> loanBooks = loanBookService.getHistoryOfIssuedBooks(id);
        return loanBookMapper.toDto(loanBooks);
    }

    @GetMapping("/overdue")
    public List<ReaderDto>  getOverdueReaders(){
        List<Reader> overdueReaders = loanBookService.getDebtors();
        return readerMapper.toDto(overdueReaders);
    }
}
