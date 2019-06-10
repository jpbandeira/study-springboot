package com.jpbandeira.springrestapi.domain;

import com.jpbandeira.springrestapi.enums.EstadoPagamento;

import javax.persistence.Entity;

@Entity
public class PagamentoComCartao extends Pagamento {
    private Integer numeroDeParcelas;

    public PagamentoComCartao() {
        super();
    }

    public PagamentoComCartao(EstadoPagamento estadoPagamento, Pedido pedido, Integer numeroDeParcelas) {
        super(estadoPagamento, pedido);
        this.numeroDeParcelas = numeroDeParcelas;
    }

    public Integer getNumeroDeParcelas() {
        return numeroDeParcelas;
    }

    public void setNumeroDeParcelas(Integer numeroDeParcelas) {
        this.numeroDeParcelas = numeroDeParcelas;
    }
}
