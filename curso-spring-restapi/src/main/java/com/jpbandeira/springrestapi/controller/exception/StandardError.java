package com.jpbandeira.springrestapi.controller.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data @EqualsAndHashCode
public class StandardError {
    private Integer status;
    private String mensagemErro;
    private Long timeStamp;

    public StandardError(Integer status, String mensagemErro, Long timeStamp) {
        this.status = status;
        this.mensagemErro = mensagemErro;
        this.timeStamp = timeStamp;
    }
}
