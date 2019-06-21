package com.jpbandeira.springrestapi.services;

import java.util.List;
import java.util.Optional;

import javassist.tools.rmi.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.jpbandeira.springrestapi.domain.Categoria;
import com.jpbandeira.springrestapi.repositories.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;

	public Categoria find(Long id) throws ObjectNotFoundException {
		Optional<Categoria> objetoCategoria = categoriaRepository.findById(id);
		return objetoCategoria.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
	}

    public Categoria insert(Categoria objetoCategoria) {
		objetoCategoria.setId(null);
		return categoriaRepository.save(objetoCategoria);
    }

	public Categoria update(Categoria objetoCategoria){
		return categoriaRepository.save(objetoCategoria);
	}

	public void delete(Long id) {
		categoriaRepository.deleteById(id);
	}

	public List<Categoria> findAll() {
		return categoriaRepository.findAll();
	}

	public Page<Categoria> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest  = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
		return categoriaRepository.findAll(pageRequest);
	}
}