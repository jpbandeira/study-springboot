package com.jpbandeira.springrestapi.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.EqualsAndHashCode;
import javax.persistence.*;

@Entity
@Data @EqualsAndHashCode
@Table(name = "Categoria")
public class Categoria implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	@JsonManagedReference
	@OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL)
	private List<Produto> produtos = new ArrayList<>();
	
	public Categoria() {}

	public Categoria(Long id ,String nome) {
		this.id = id;
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Categoria{" +
				"id=" + id +
				", nome='" + nome + '\'' +
				", produtos=" + produtos +
				'}';
	}
}