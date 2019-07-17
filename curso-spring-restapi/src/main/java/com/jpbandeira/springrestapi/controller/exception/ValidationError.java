package com.jpbandeira.springrestapi.controller.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

@Data @EqualsAndHashCode
public class ValidationError extends StandardError {

    List<FieldMessage> errors = new ArrayList<>();

    public ValidationError(Integer status, String mensagemErro, Long timeStamp) {
        super(status, mensagemErro, timeStamp);
    }

    public void addError(String fildName, String message){
        errors.add(new FieldMessage(fildName, message));
    }
}
