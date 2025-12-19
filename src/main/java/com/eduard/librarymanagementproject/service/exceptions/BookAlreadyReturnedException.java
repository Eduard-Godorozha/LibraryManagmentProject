package com.eduard.librarymanagementproject.service.exceptions;

public class BookAlreadyReturnedException extends RuntimeException {

    public BookAlreadyReturnedException(String message) {
        super(message);
    }
}
