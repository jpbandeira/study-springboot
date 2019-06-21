package com.jpbandeira.springrestapi.controller;


import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.jpbandeira.springrestapi.dto.CategoriaDto;
import javassist.tools.rmi.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.jpbandeira.springrestapi.domain.Categoria;
import com.jpbandeira.springrestapi.services.CategoriaService;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaController {
	
	@Autowired
	private CategoriaService categoriaService;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<?> find(@PathVariable Long id) throws ObjectNotFoundException {
		Optional<Categoria> objetoCategoria = Optional.ofNullable(categoriaService.find(id));
		return ResponseEntity.ok().body(objetoCategoria);
	}

	@GetMapping()
	public ResponseEntity<List<CategoriaDto>> findAll() throws ObjectNotFoundException {
		List<Categoria> categoriaList = categoriaService.findAll();
		List<CategoriaDto> categoriaDtoList = categoriaList.stream().map(objeto -> new CategoriaDto(objeto)).collect(Collectors.toList());
		return ResponseEntity.ok().body(categoriaDtoList);
	}

	@PostMapping
	public ResponseEntity<Void> insert(@Valid @RequestBody Categoria objetoCategoria){
		objetoCategoria = categoriaService.insert(objetoCategoria);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(objetoCategoria.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@PutMapping()
	public ResponseEntity<Void> update(@Valid @RequestBody Categoria objetoCategoria){
		System.out.println(objetoCategoria.toString());
		categoriaService.update(objetoCategoria);
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		categoriaService.delete(id);
		return  ResponseEntity.noContent().build();
	}

	@GetMapping(value = "/page")
	public ResponseEntity<Page<CategoriaDto>> findPage(@RequestParam(value = "page", defaultValue = "0") Integer page,
									   @RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
									   @RequestParam(value = "orderBy", defaultValue = "nome") String orderBy,
									   @RequestParam(value = "direction", defaultValue = "ASC") String direction){
		Page<Categoria> categoriaList = categoriaService.findPage(page, linesPerPage, orderBy, direction);
		Page<CategoriaDto> categoriaDtoList = categoriaList.map(objeto -> new CategoriaDto(objeto));
		return ResponseEntity.ok().body(categoriaDtoList);
	}

}