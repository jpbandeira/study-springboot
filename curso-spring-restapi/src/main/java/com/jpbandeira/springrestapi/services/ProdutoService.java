package com.jpbandeira.springrestapi.services;

import com.jpbandeira.springrestapi.domain.Produto;
import com.jpbandeira.springrestapi.repositories.ProdutoRepository;
import javassist.tools.rmi.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository repository;

	public Produto find(Long id) throws ObjectNotFoundException {
		Optional<Produto> objetoProduto = repository.findById(id);
		return objetoProduto.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Produto.class.getName()));
	}

    public Produto insert(Produto objetoProduto) {
		objetoProduto.setId(null);
		return repository.save(objetoProduto);
    }

	public Produto update(Produto objetoProduto){
		return repository.save(objetoProduto);
	}

	public void delete(Long id) {
		repository.deleteById(id);
	}

}