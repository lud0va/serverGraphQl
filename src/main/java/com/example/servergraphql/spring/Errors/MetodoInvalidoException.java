package com.example.servergraphql.spring.Errors;

public class MetodoInvalidoException extends RuntimeException{

    public MetodoInvalidoException(String message) {
       super("Metodo invalido");
    }
}
