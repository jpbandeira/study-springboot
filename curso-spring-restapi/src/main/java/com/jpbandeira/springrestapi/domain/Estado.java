package com.jpbandeira.springrestapi.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
@Entity
public class Estado implements Serializable {
    @OneToMany(mappedBy = "estado")
    private List<Cidade> cidades = new ArrayList<>();
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;

    public Estado(){}

    public Estado(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public List<Cidade> getCidades() {
        return cidades;
    }

    public void setCidades(List<Cidade> cidades) {
        this.cidades = cidades;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Estado estado = (Estado) o;

        return cidades != null ? cidades.equals(estado.cidades) : estado.cidades == null;
    }

    @Override
    public int hashCode() {
        return cidades != null ? cidades.hashCode() : 0;
    }
}
