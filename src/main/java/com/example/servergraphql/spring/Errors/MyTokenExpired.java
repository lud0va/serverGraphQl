package com.example.servergraphql.spring.Errors;

public class MyTokenExpired extends RuntimeException{
    public MyTokenExpired(String message) {
        super("Token caducado");
    }
}
