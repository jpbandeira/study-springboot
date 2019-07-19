package com.jpbandeira.springrestapi.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity @Data @EqualsAndHashCode
public class Pedido  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private Date instantePedido;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "pedido")
    @JsonManagedReference
    private Pagamento pagamento;
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
    @ManyToOne
    @JoinColumn(name = "endereco_entrega_id")
    private Endereco enderecoEntrega;

    @OneToMany(mappedBy = "id.pedido")
    private Set<ItemPedido> itens = new HashSet<>();

    public Pedido(){}

    public Pedido(Date instantePedido, Cliente cliente, Endereco enderecoEntrega) {
        this.instantePedido = instantePedido;
        this.cliente = cliente;
        this.enderecoEntrega = enderecoEntrega;
    }

}