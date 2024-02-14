package com.example.servergraphql.spring.Errors;

public class NotFoundElementException extends RuntimeException{
    public NotFoundElementException(String message) {
        super("Metodo invalido");
    }

}
