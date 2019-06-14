package com.jpbandeira.springrestapi.resources;


import java.net.URI;
import java.util.Optional;

import javassist.tools.rmi.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.jpbandeira.springrestapi.domain.Categoria;
import com.jpbandeira.springrestapi.services.CategoriaService;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {
	
	@Autowired
	private CategoriaService categoriaService;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<?> find(@PathVariable Long id) throws ObjectNotFoundException {
		Optional<Categoria> objetoCategoria = Optional.ofNullable(categoriaService.find(id));
		return ResponseEntity.ok().body(objetoCategoria);
	}


	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody Categoria objetoCategoria){
		objetoCategoria = categoriaService.insert(objetoCategoria);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(objetoCategoria.getId()).toUri();

		return ResponseEntity.created(uri).build();
	}

	@PutMapping()
	public ResponseEntity<Void> update(@RequestBody Categoria objetoCategoria){
		System.out.println(objetoCategoria.toString());
		categoriaService.update(objetoCategoria);
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		categoriaService.delete(id);
		return  ResponseEntity.noContent().build();
	}
}