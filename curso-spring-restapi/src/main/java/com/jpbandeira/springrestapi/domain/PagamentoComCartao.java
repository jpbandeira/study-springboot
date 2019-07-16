package com.jpbandeira.springrestapi.domain;

import com.jpbandeira.springrestapi.enums.EstadoPagamento;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;

@Entity
@Data
@EqualsAndHashCode
public class PagamentoComCartao extends Pagamento {
    private Integer numeroDeParcelas;

    public PagamentoComCartao() {
        super();
    }

    public PagamentoComCartao(EstadoPagamento estadoPagamento, Pedido pedido, Integer numeroDeParcelas) {
        super(estadoPagamento, pedido);
        this.numeroDeParcelas = numeroDeParcelas;
    }
}
