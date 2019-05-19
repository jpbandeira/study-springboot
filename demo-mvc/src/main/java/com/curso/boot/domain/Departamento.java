package com.curso.boot.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "DEPARTAMENTOS")
public class Departamento extends AbstractEntity<Long> {
	
	@OneToMany(mappedBy = "departamento")
	private List<Cargo> listaDeCargos;

	@Column(name = "nome", nullable = false, unique = true, length = 60)
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Cargo> getListaDeCargos() {
		return listaDeCargos;
	}

	public void setListaDeCargos(List<Cargo> listaDeCargos) {
		this.listaDeCargos = listaDeCargos;
	}
}
