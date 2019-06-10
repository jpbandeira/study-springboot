package com.jpbandeira.springrestapi.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Produto extends AbstractEntity<Long>  implements Serializable {

    private String nome;
    private Double preco;

    /*Essa anotação verifica se no outro lado da associação já foi buscado os objetos, então ele omite a lista
    * de categorias para cada produto*/
    @JsonIgnore
    @ManyToMany
    /*Como nesse caso temos uma relação de muitos para muitos entre produto e categoria
     * é usada a anotação JoinTable, onde será criada uma tabela de comunicação entre as duas tabelas
     * contendo os ids das duas
     * Nesse caso é passado o nome dessa tabela que ira intermedias as duas e é passado o nome das duas fks, tanto da tabela Categoria como produto
     * joinColum informa o nome da campo em que esta sendo feito o mapeamento e inverseJoinColumns informa no nome do campo da tabela inversa ao mapeamento*/
    @JoinTable(name = "Produto_Categoria", joinColumns = @JoinColumn(name = "Produto_id"), inverseJoinColumns = @JoinColumn(name = "Categoria_id"))
    private List<Categoria> categorias = new ArrayList<>();
    @JsonIgnore
    @OneToMany(mappedBy = "id.produto")
    private Set<ItemPedido> itens = new HashSet<>();

    public Produto(){}

    public Produto(String nome, Double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    @JsonIgnore
    public List<Pedido> getPedidos(){
        List<Pedido> listaPedidos = new ArrayList<>();
        for(ItemPedido itemPedido : itens){
            listaPedidos.add(itemPedido.getPedido());
        }
        return listaPedidos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }

    public Set<ItemPedido> getItens() {
        return itens;
    }

    public void setItens(Set<ItemPedido> itens) {
        this.itens = itens;
    }
}
