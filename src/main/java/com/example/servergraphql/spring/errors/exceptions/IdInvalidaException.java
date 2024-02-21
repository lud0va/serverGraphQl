package com.example.servergraphql.spring.errors.exceptions;

import com.example.servergraphql.common.Constantes;

public class IdInvalidaException extends RuntimeException{

    public IdInvalidaException() {
        super(Constantes.ID_INTRODUCIDA_NO_ES_VALIDA);
    }
}
