package com.eduard.librarymanagementproject.web.mapper;

import com.eduard.librarymanagementproject.model.entity.Book;
import com.eduard.librarymanagementproject.web.dto.BookDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookMapper {

    BookDto toDto(Book book);

    List<BookDto> toDto(List<Book> books);

    Book toEntity(BookDto dto);

}
