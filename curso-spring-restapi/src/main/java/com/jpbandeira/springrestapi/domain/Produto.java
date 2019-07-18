package com.jpbandeira.springrestapi.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.tomcat.util.digester.ArrayStack;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity @Data @EqualsAndHashCode
public class Produto  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Double preco;
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    @OneToMany(mappedBy = "id.produto")
    private Set<Carrinho> itens = new HashSet<>();

    public Produto(){}

    public Produto(Long id,String nome, Double preco, Categoria categoria) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.categoria = categoria;
    }

    public List<Pedido> getPedidos(){
        List<Pedido> listaDePedidos = new ArrayList<>();
        for(Carrinho pedidos : itens){
            listaDePedidos.add(pedidos.getPedido());
        }
        return listaDePedidos;
    }

}
