package com.jpbandeira.springrestapi.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jpbandeira.springrestapi.domain.CategoriaD;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {
	
	@RequestMapping(method = RequestMethod.GET)
	public List<CategoriaD> listar() {
		List<CategoriaD> listaDeCategorias = new ArrayList<>();
		CategoriaD categoria1 = new CategoriaD(1, "Informatica");
		CategoriaD categoria2 = new CategoriaD(2, "Escritorio");
		listaDeCategorias.add(categoria1);
		listaDeCategorias.add(categoria2);
		return listaDeCategorias;
	}
}