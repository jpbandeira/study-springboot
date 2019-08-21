package com.workshopmongo.workshopmongo.service.exception;

public class ObjectNotFoundException extends RuntimeException {

    public ObjectNotFoundException(String mensagem){
        super(mensagem);
    }
}
