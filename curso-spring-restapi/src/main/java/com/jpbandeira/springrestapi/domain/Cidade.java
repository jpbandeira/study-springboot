package com.jpbandeira.springrestapi.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "Cidade")
public class Cidade  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
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

    @Override
    public String toString() {
        return "Cidade{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", estado=" + estado +
                '}';
    }
}
