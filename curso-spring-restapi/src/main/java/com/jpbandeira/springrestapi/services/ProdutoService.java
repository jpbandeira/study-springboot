package com.jpbandeira.springrestapi.services;

import com.jpbandeira.springrestapi.domain.Categoria;
import com.jpbandeira.springrestapi.domain.Produto;
import com.jpbandeira.springrestapi.repositories.CategoriaRepository;
import com.jpbandeira.springrestapi.repositories.ProdutoRepository;
import javassist.tools.rmi.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

	private ProdutoRepository produtoRepository;
	private CategoriaRepository categoriaRepository;

	@Autowired
	public ProdutoService(ProdutoRepository produtoRepository, CategoriaRepository categoriaRepository){
		this.produtoRepository = produtoRepository;
		this.categoriaRepository = categoriaRepository;
	}

	public Produto find(Integer id) throws ObjectNotFoundException {
		Optional<Produto> objetoProduto = produtoRepository.findById(id);
		return objetoProduto.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Produto.class.getName()));
	}

    public Produto insert(Produto objetoProduto) {
		objetoProduto.setId(null);
		return produtoRepository.save(objetoProduto);
    }

	public Produto update(Produto objetoProduto){
		return produtoRepository.save(objetoProduto);
	}

	public void delete(Integer id) {
		produtoRepository.deleteById(id);
	}

	public Page<Produto> search(String nome, List<Integer> ids, Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
		List<Categoria> categorias = categoriaRepository.findAllById(ids);
		return produtoRepository.findDistinctByNomeContainingAndCategoriaIn(nome, categorias, pageRequest);
	}

}