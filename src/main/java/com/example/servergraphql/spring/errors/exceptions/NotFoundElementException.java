package com.example.servergraphql.spring.errors.exceptions;

public class NotFoundElementException extends RuntimeException{
    public NotFoundElementException(String message) {
        super(message);
    }

}
