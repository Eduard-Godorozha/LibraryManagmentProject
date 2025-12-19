package com.eduard.librarymanagementproject.web.exception;

import com.eduard.librarymanagementproject.service.exceptions.BookAlreadyReturnedException;
import com.eduard.librarymanagementproject.service.exceptions.BookNotAvailableException;
import com.eduard.librarymanagementproject.service.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleResourceNotFoundException(ResourceNotFoundException ex) {
        return ex.getMessage();
    }

    @ExceptionHandler({
            BookNotAvailableException.class,
            BookAlreadyReturnedException.class
    })
    @ResponseStatus(HttpStatus.CONFLICT)
    public String handleConflict(RuntimeException ex){
        return ex.getMessage();
    }
}
