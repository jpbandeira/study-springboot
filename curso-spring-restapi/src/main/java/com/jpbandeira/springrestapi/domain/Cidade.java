package com.jpbandeira.springrestapi.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "Cidade")
public class Cidade extends AbstractEntity<Long>  implements Serializable {
    private String nome;

    @JsonManagedReference
    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "estado_id")
    private Estado estado;

    public Cidade(){}

    public Cidade(String nome, Estado estado) {

        this.nome = nome;
        this.estado = estado;
    }public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
}
