package com.jpbandeira.springrestapi.controller;

import com.jpbandeira.springrestapi.domain.Produto;
import com.jpbandeira.springrestapi.services.ProdutoService;
import javassist.tools.rmi.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoController {
	
	@Autowired
	private ProdutoService produtoService;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<?> find(@PathVariable Long id) throws ObjectNotFoundException {
		Optional<Produto> objetoProduto = Optional.ofNullable(produtoService.find(id));
		return ResponseEntity.ok().body(objetoProduto);
	}


	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody Produto objetoProduto){
		objetoProduto = produtoService.insert(objetoProduto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(objetoProduto.getId()).toUri();

		return ResponseEntity.created(uri).build();
	}

	@PutMapping
	public ResponseEntity<Void> update(@RequestBody Produto objetoProduto){
		System.out.println(objetoProduto.toString());
		produtoService.update(objetoProduto);
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		produtoService.delete(id);
		return ResponseEntity.noContent().build();
	}
}