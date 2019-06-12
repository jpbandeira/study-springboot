package com.jpbandeira.springrestapi.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "Categoria")
public class Categoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	/*Essa anotação faz a gerencia do objetos associados vindos do outro dominio, transformando em json os seus dados*/

	/*No caso desse lado, como o mapeamento foi feito pela entidade Produto, aqui é colocada a anotação ManyToMany
	* informando com o mappedBy que foi mapeado pela entidade categorias*/
	@ManyToMany(mappedBy = "categorias")
	private List<Produto> produtos = new ArrayList<>();
	
	public Categoria() {}

	public Categoria(String nome) {
		this.nome = nome;
	}

	public String getnome() {
		return nome;
	}

	public void setnome(String nome) {
		this.nome = nome;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	@Override
	public String toString() {
		return "Categoria{" +
				"id=" + id +
				", nome='" + nome + '\'' +
				", produtos=" + produtos +
				'}';
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}