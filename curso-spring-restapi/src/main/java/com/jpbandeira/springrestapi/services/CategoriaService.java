package com.jpbandeira.springrestapi.services;

import java.util.List;
import java.util.Optional;

import com.jpbandeira.springrestapi.dto.CategoriaDto;
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
	private CategoriaRepository repository;

	public Categoria find(Integer id) throws ObjectNotFoundException {
		Optional<Categoria> objeto = repository.findById(id);
		return objeto.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
	}

    public Categoria insert(Categoria objeto) {
		objeto.setId(null);
		return repository.save(objeto);
    }

	public Categoria update(Categoria objeto) throws ObjectNotFoundException {
		Categoria newObj = find(objeto.getId());
		updateData(newObj, objeto);
		return repository.save(objeto);
	}

	public void delete(Integer id) {
		repository.deleteById(id);
	}

	public List<Categoria> findAll() {
		return repository.findAll();
	}

	public Page<Categoria> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest  = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
		return repository.findAll(pageRequest);
	}

	public Categoria fromDTO(CategoriaDto objetoDto) {
		return new Categoria(objetoDto.getId(), objetoDto.getNome());
	}

	private void updateData(Categoria newObj, Categoria obj) {
		newObj.setNome(obj.getNome());
	}

}