package com.jpbandeira.springrestapi.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpbandeira.springrestapi.domain.Categoria;
import com.jpbandeira.springrestapi.repositories.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public Optional<Categoria> buscar(Integer id) {
		Optional<Categoria> objetoCategoria = categoriaRepository.findById(id);
		return objetoCategoria;
	}
	
}
