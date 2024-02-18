package com.example.servergraphql.spring.Errors;

public class IdInvalidaException extends RuntimeException{
public IdInvalidaException(String message) {
        super("Id introducida no es valida");
    }
}
