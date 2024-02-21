package com.example.servergraphql.spring.errors.exceptions;

import com.example.servergraphql.common.Constantes;

public class ElementosInvalidos extends RuntimeException{

    public ElementosInvalidos() {
        super(Constantes.ALGUNO_DE_LOS_ELEMENTOS_INTRODUCIDOS_NO_ES_VALIDO);
    }
}
