package com.jpbandeira.springrestapi.domain;

import java.io.Serializable;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/*Informa que essa classe é um subtipo da classe em que ela será atributo*/
@Embeddable
public class ItemPedidoPK implements Serializable {
    @ManyToOne
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;
    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ItemPedidoPK that = (ItemPedidoPK) o;

        if (pedido != null ? !pedido.equals(that.pedido) : that.pedido != null) return false;
        return produto != null ? produto.equals(that.produto) : that.produto == null;
    }

    @Override
    public int hashCode() {
        int result = pedido != null ? pedido.hashCode() : 0;
        result = 31 * result + (produto != null ? produto.hashCode() : 0);
        return result;
    }
}
