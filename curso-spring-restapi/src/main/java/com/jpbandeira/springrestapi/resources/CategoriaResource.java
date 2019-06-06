package com.jpbandeira.springrestapi.resources;


import java.util.Optional;

import javassist.tools.rmi.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jpbandeira.springrestapi.domain.Categoria;
import com.jpbandeira.springrestapi.services.CategoriaService;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {
	
	@Autowired
	private CategoriaService categoriaService;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<?> find(@PathVariable Integer id) throws ObjectNotFoundException {
		Optional<Categoria> objetoCategoria = Optional.ofNullable(categoriaService.buscar(id));
		return ResponseEntity.ok().body(objetoCategoria);
	}
}