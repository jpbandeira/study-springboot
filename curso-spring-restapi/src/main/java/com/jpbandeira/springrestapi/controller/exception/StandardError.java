package com.jpbandeira.springrestapi.controller.exception;

public class StandardError {
    private Integer status;
    private String mensagemErro;
    private Long timeStamp;

    public StandardError(Integer status, String mensagemErro, Long timeStamp) {
        this.status = status;
        this.mensagemErro = mensagemErro;
        this.timeStamp = timeStamp;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMensagemErro() {
        return mensagemErro;
    }

    public void setMensagemErro(String mensagemErro) {
        this.mensagemErro = mensagemErro;
    }

    public Long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Long timeStamp) {
        this.timeStamp = timeStamp;
    }
}
