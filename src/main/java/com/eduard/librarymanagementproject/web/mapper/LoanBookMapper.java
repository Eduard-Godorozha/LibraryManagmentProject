package com.eduard.librarymanagementproject.web.mapper;

import com.eduard.librarymanagementproject.model.entity.Book;
import com.eduard.librarymanagementproject.model.entity.LoanBook;
import com.eduard.librarymanagementproject.model.entity.Reader;
import com.eduard.librarymanagementproject.web.dto.BookDto;
import com.eduard.librarymanagementproject.web.dto.LoanBookDto;
import com.eduard.librarymanagementproject.web.dto.ReaderDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LoanBookMapper {

    LoanBookDto toDto(LoanBook loanBook);

    List<LoanBookDto> toDto(List<LoanBook> loanBookList);

    LoanBook toEntity(LoanBookDto loanBookDto);

    BookDto toDto(Book book);

    ReaderDto toDto(Reader reader);

}
