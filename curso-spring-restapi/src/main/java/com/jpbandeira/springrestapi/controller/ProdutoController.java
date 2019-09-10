package com.jpbandeira.springrestapi.controller;

import com.jpbandeira.springrestapi.controller.utils.URL;
import com.jpbandeira.springrestapi.domain.Produto;
import com.jpbandeira.springrestapi.dto.ProdutoDto;
import com.jpbandeira.springrestapi.services.ProdutoService;
import javassist.tools.rmi.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoController {
	
	@Autowired
	private ProdutoService produtoService;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<?> find(@PathVariable Integer id) throws ObjectNotFoundException {
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
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		produtoService.delete(id);
		return ResponseEntity.noContent().build();
	}

	@GetMapping
	public ResponseEntity<Page<ProdutoDto>> findPage(
													 @RequestParam(value = "nome", defaultValue = "") String nome,
													 @RequestParam(value = "categorias", defaultValue = "") String categorias,
													 @RequestParam(value = "page", defaultValue = "0") Integer page,
													 @RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
													 @RequestParam(value = "orderBy", defaultValue = "nome") String orderBy,
													 @RequestParam(value = "direction", defaultValue = "ASC") String direction) throws UnsupportedEncodingException {
		List<Integer> ids = URL.decodeIntList(categorias);
		String nomeDecoded = URL.decodeParam(nome);
		Page<Produto> produtos = produtoService.search(nomeDecoded, ids, page, linesPerPage, orderBy, direction);
		Page<ProdutoDto> produtoDtos = produtos.map(objeto -> new ProdutoDto(objeto));
		return ResponseEntity.ok().body(produtoDtos);
	}
}