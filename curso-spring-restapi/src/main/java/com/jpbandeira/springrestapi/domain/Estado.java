package com.jpbandeira.springrestapi.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
@Entity
public class Estado  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonIgnore
    @OneToMany(mappedBy = "estado")
    private List<Cidade> cidades = new ArrayList<>();

    private String nome;

    public Estado() {
    }

    public Estado(String nome) {

        this.nome = nome;
    }

    public List<Cidade> getCidades() {
        return cidades;
    }

    public void setCidades(List<Cidade> cidades) {
        this.cidades = cidades;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Estado{" +
                "id=" + id +
                ", cidades=" + cidades +
                ", nome='" + nome + '\'' +
                '}';
    }
}
