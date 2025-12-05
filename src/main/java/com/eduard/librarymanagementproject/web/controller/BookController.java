package com.eduard.librarymanagementproject.web.controller;

import com.eduard.librarymanagementproject.model.entity.Book;
import com.eduard.librarymanagementproject.service.book.BookService;
import com.eduard.librarymanagementproject.web.dto.BookDto;
import com.eduard.librarymanagementproject.web.mapper.BookMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    private final BookMapper bookMapper;

    @GetMapping
    public List<BookDto> getAllBooks() {
        return bookMapper.toDto(bookService.getAllBooks());
    }

    @GetMapping("/{id}")
    public BookDto getBookById(@PathVariable Long id) {
        return bookMapper.toDto(bookService.getBookById(id));
    }

    @GetMapping("/search")
    public List<BookDto> searchBooks(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String isbn) {

        List<Book> books = bookService.getByNameOrIsbn(name, isbn);
        return bookMapper.toDto(books);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BookDto createBook(@RequestBody @Valid BookDto bookDto) {
        Book book = bookMapper.toEntity(bookDto);
        book = bookService.createBook(book);
        return bookMapper.toDto(book);
    }

    @PutMapping("/{id}")
    public BookDto updateBook(@PathVariable Long id, @RequestBody @Valid BookDto bookDto) {
        Book book = bookMapper.toEntity(bookDto);
        book = bookService.updateBook(id, book);
        return bookMapper.toDto(book);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteBookById(id);
    }
}
