package com.example.servergraphql.spring.Errors.exceptions;

public class NotFoundElementException extends RuntimeException{
    public NotFoundElementException(String message) {
        super(message);
    }

}
