package com.example.servergraphql.spring.Errors.exceptions;

public class MyTokenExpired extends RuntimeException{
    public MyTokenExpired(String message) {
        super("Token caducado");
    }
}
