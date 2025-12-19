package com.eduard.librarymanagementproject.service.exceptions;

public class BookNotAvailableException extends RuntimeException{

    public BookNotAvailableException(String message) {
        super(message);
    }

}
