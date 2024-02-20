package com.example.servergraphql.spring.Errors.exceptions;

public class IdInvalidaException extends RuntimeException{
public IdInvalidaException() {
        super("Id introducida no es valida");
    }
}
