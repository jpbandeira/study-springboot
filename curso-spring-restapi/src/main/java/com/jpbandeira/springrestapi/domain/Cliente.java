package com.jpbandeira.springrestapi.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.jpbandeira.springrestapi.enums.TipoCliente;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
public class Cliente  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String cpfOuCnpj;
    /*Nessea atributo não sera armazenado um dado tipo cliente, mas sim um dado do tipo inteiro
    * Internamente o tipo cliente sera armazenado como inteiro, mas de maneira externa a classe expoe um dado do tipo CLiente*/
    private Integer tipoCliente;
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Endereco> enderecos = new ArrayList<>();
    @JsonIgnore
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Pedido> pedidos = new ArrayList<>();
    @ElementCollection
    @CollectionTable(name = "telefone")
    private Set<String> telefones = new HashSet<>();

    public  Cliente(){}

    public Cliente(String nome, String email, String cpfOuCnpj, TipoCliente tipoCliente) {
        this.nome = nome;
        this.email = email;
        this.cpfOuCnpj = cpfOuCnpj;
        this.tipoCliente = tipoCliente.getCodigo();
    }

    public TipoCliente getTipoCliente() {
        /*Para retorno foi definido no enum a maneira como vai ser retornado
         * Dessa forma, no retorno deve ir o toEnum, passando o tipoCliente*/
        return TipoCliente.toEnum(tipoCliente);
    }

    public void setTipoCliente(TipoCliente tipoCliente) {
        this.tipoCliente = tipoCliente.getCodigo();
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", cpfOuCnpj='" + cpfOuCnpj + '\'' +
                ", tipoCliente=" + tipoCliente +
                ", enderecos=" + enderecos +
                ", pedidos=" + pedidos +
                ", telefones=" + telefones +
                '}';
    }
}

