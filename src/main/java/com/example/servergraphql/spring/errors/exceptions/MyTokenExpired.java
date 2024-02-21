package com.example.servergraphql.spring.errors.exceptions;

import com.example.servergraphql.common.Constantes;

public class MyTokenExpired extends RuntimeException{

    public MyTokenExpired() {
        super(Constantes.TOKEN_CADUCADO);
    }
}
