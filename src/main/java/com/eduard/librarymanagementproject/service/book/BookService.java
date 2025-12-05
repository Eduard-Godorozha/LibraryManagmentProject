package com.eduard.librarymanagementproject.service.book;

import com.eduard.librarymanagementproject.model.entity.Book;
import org.hibernate.validator.constraints.ISBN;

import java.util.List;

public interface BookService {

    Book getBookById(Long id);

    List<Book> getByNameOrIsbn(String name, String isbn);

    List<Book> getAllBooks();

    Book createBook(Book book);

    Book updateBook(Long id, Book book);

    void deleteBookById(Long id);
}
