package com.curso.boot.web.controller;

import com.curso.boot.domain.Departamento;
import com.curso.boot.service.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/departamentos")
public class DepartamentoController {

	@Autowired
	private DepartamentoService departamentoService;

	@GetMapping("/cadastrar")
	public String cadastrarDepartamento() {
		return "/departamento/cadastro";
	}

	@PostMapping("/salvar")
	public String salvar(Departamento departamento){
		departamentoService.salvar(departamento);
		return "redirect:/departamento/cadastro";
	}

	@GetMapping("/listar")
	public String listarDepartamento(ModelMap modelMap) {
		modelMap.addAttribute("departamento", departamentoService.buscarTodos());
		return "/departamento/lista";
	}

	// Esse metodo recupera o objeto pelo id pelo a url para saber qual sera editado
	// @PathVariable recupera pela url o atributo enviado, que nesse caso é o id.
	// ModelMapp envia o departamento como uma variavel para a pagina de cadastro
	// Depois, abre a pagina de cadastro, alterando aquele atribruto
	@GetMapping("/editar/{id}")
	public  String buscarIdDoAtributoParaPreEditar(@PathVariable("id") Long id, ModelMap modelMap){
		modelMap.addAttribute("departamento", departamentoService.buscarPorId(id));
		return "/departamentos/cadastro";
	}

	@PostMapping("/editar")
	public String editar(Departamento departamento){
		departamentoService.editar(departamento);
		return "redirect://departamentos/cadastrar";
	}



}
