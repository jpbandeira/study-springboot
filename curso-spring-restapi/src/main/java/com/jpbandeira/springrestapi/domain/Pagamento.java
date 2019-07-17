package com.jpbandeira.springrestapi.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jpbandeira.springrestapi.enums.EstadoPagamento;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data @EqualsAndHashCode
@Inheritance(strategy = InheritanceType.JOINED)
public class Pagamento  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer estadoPagamento;
    @JsonIgnore @OneToOne @JoinColumn(name = "pedido_id")
    private Pedido pedido;

    public Pagamento(){}

    public Pagamento(Long id ,EstadoPagamento estadoPagamento, Pedido pedido) {
        this.id = id;
        this.estadoPagamento = (estadoPagamento==null) ? null : estadoPagamento.getCodigo();
        this.pedido = pedido;
    }

    public EstadoPagamento getEstadoPagamento() {
        return EstadoPagamento.toEnum(estadoPagamento);
    }

    public void setEstadoPagamento(EstadoPagamento estadoPagamento) {
        this.estadoPagamento = estadoPagamento.getCodigo();
    }

}
