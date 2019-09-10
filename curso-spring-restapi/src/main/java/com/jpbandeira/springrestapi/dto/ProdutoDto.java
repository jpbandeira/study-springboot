package com.jpbandeira.springrestapi.dto;

import com.jpbandeira.springrestapi.domain.Categoria;
import com.jpbandeira.springrestapi.domain.Produto;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Data @EqualsAndHashCode
public class ProdutoDto implements Serializable {

    private Integer id;
    private String nome;
    private Double preco;

    public ProdutoDto(){}

    public ProdutoDto(Produto produto) {
        this.id = produto.getId();
        this.nome = produto.getNome();
        this.preco = produto.getPreco();
    }
}