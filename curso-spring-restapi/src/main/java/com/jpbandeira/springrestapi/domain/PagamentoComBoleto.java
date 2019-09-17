package com.jpbandeira.springrestapi.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.jpbandeira.springrestapi.enums.EstadoPagamento;
import lombok.Data;
import lombok.EqualsAndHashCode;
import javax.persistence.Entity;
import java.util.Date;

@Entity
@Data @EqualsAndHashCode
@JsonTypeName("pagamentoComBoleto")
public class PagamentoComBoleto extends Pagamento {
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dataVencimento;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dataPagamento;

    public PagamentoComBoleto() {
        super();
    }

    public PagamentoComBoleto(Integer id ,EstadoPagamento estadoPagamento, Pedido pedido, Date dataVencimento, Date dataPagamento) {
        super(id ,estadoPagamento, pedido);
        this.dataVencimento = dataVencimento;
        this.dataPagamento = dataPagamento;
    }
}
