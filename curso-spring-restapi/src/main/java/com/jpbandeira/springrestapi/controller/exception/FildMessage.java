package com.jpbandeira.springrestapi.controller.exception;

import lombok.Data;

import java.io.Serializable;

@Data
public class FildMessage implements Serializable {

    private String fildName;
    private String message;

    public FildMessage(){}

    public FildMessage(String fildName, String message) {
        this.fildName = fildName;
        this.message = message;
    }
}
