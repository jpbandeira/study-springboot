package com.jpbandeira.springrestapi.controller.exception;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ValidationError extends StandardError {

    List<FildMessage> errors = new ArrayList<>();

    public ValidationError(Integer status, String mensagemErro, Long timeStamp) {
        super(status, mensagemErro, timeStamp);
    }

    public void addError(String fildName, String message){
        errors.add(new FildMessage(fildName, message));
    }
}
