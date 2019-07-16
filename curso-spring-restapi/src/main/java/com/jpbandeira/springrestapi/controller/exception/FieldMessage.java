package com.jpbandeira.springrestapi.controller.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data @EqualsAndHashCode
public class FieldMessage implements Serializable {

    private String fieldName;
    private String message;

    public FieldMessage(){}

    public FieldMessage(String fieldName, String message) {
        this.fieldName = fieldName;
        this.message = message;
    }
}
