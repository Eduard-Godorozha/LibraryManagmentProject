package com.eduard.librarymanagementproject.service.book;

import com.eduard.librarymanagementproject.model.entity.Book;
import com.eduard.librarymanagementproject.repository.BookRepository;
import com.eduard.librarymanagementproject.service.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DefaultBookService implements BookService{

    private final BookRepository bookRepository;

    @Override
    public Book getBookById(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found"));
    }

    @Override
    public Book getBookByName(String name) {
        return bookRepository.findByName(name)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found"));
    }

    @Override
    public Book getBookByISBN(String isbn) {
        return bookRepository.findByISBN(isbn)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found"));
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book updateBook(Long id, Book book) {
        Book updatedBook = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found"));

        updatedBook.setName(book.getName());
        updatedBook.setAuthor(book.getAuthor());
        updatedBook.setNumberOfCopies(book.getNumberOfCopies());
        updatedBook.setYearOfPublication(book.getYearOfPublication());

        return bookRepository.save(updatedBook);
    }

    @Override
    public void deleteBookById(Long id) {
        bookRepository.deleteById(id);
    }
}
