package com.workshopmongo.workshopmongo.controler.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data @AllArgsConstructor @NoArgsConstructor
public class StandardError implements Serializable {

    private Integer status;
    private String error;
    private String message;
    private String path;

}
