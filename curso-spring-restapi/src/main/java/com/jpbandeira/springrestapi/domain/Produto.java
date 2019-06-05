package com.jpbandeira.springrestapi.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Produto implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private Double preco;
    @ManyToMany
    /*Como nesse caso temos uma relação de muitos para muitos entre produto e categoria
     * é usada a anotação JoinTable, onde será criada uma tabela de comunicação entre as duas tabelas
     * contendo os ids das duas
     * Nesse caso é passado o nome dessa tabela que ira intermedias as duas e é passado o nome das duas fks, tanto da tabela Categoria como produto
     * joinColum informa o nome da campo em que esta sendo feito o mapeamento e inverseJoinColumns informa no nome do campo da tabela inversa ao mapeamento*/
    @JoinTable(name = "Produto_Categoria", joinColumns = @JoinColumn(name = "Produto_id"), inverseJoinColumns = @JoinColumn(name = "Categoria_id"))
    private List<Categoria> categorias = new ArrayList<>();

    public Produto(){}

    public Produto(Integer id,String nome, Double preco) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Produto other = (Produto) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
}
