package com.jpbandeira.springrestapi.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
@Data @EqualsAndHashCode
public class Carrinho {

    /*Id embutido em um tipo auxiliar*/
    @EmbeddedId
    private CarrinhoPK id = new CarrinhoPK();

    private Double desconto;
    private Integer quantidade;
    private Double preco;

    public Carrinho(){
    }

    public Carrinho(Produto produto, Pedido pedido, Double desconto, Integer quantidade, Double preco) {
        this.id.setPedido(pedido);
        this.id.setProduto(produto);
        this.desconto = desconto;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public Pedido getPedido(){
        return id.getPedido();
    }

    public Produto getProduto(){
        return id.getProduto();
    }
}
