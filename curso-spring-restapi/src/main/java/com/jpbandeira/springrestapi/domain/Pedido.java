package com.jpbandeira.springrestapi.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@EqualsAndHashCode
public class Pedido  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private Date instantePedido;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "pedido")
    private Pagamento pagamento;
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
    @ManyToOne
    @JoinColumn(name = "endereco_entrega_id")
    private Endereco enderecoEntrega;
    @OneToMany(mappedBy = "id.pedido", cascade = CascadeType.ALL)
    private Set<ItemPedido> itens = new HashSet<>();

    public Pedido(){}

    public Pedido(Date instantePedido, Cliente cliente, Endereco enderecoEntrega) {
        this.instantePedido = instantePedido;
        this.cliente = cliente;
        this.enderecoEntrega = enderecoEntrega;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", instantePedido=" + instantePedido +
                ", pagamento=" + pagamento +
                ", cliente=" + cliente +
                ", enderecoEntrega=" + enderecoEntrega +
                ", itens=" + itens +
                '}';
    }
}