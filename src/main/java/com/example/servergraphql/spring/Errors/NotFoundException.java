package com.example.servergraphql.spring.Errors;

public class NotFoundException extends RuntimeException{
    public NotFoundException(String message) {
        super("Metodo invalido");
    }

}
