package com.jpbandeira.springrestapi.services;

import java.util.Optional;

import javassist.tools.rmi.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpbandeira.springrestapi.domain.Categoria;
import com.jpbandeira.springrestapi.repositories.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;

	public Categoria buscar(Integer id) throws ObjectNotFoundException {
		Optional<Categoria> objetoCategoria = categoriaRepository.findById(id);
		return objetoCategoria.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
	}
}