package com.curso.boot.web.controller;

import com.curso.boot.domain.Funcionario;
import com.curso.boot.service.CargoService;
import com.curso.boot.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/funcionarios")
public class FuncionarioController {

	@Autowired
	private FuncionarioService funcionarioService;
	@Autowired
	private CargoService cargoService;

	@GetMapping("/cadastrar")
	public String cadastrarFuncionario() {
		return "/funcionario/cadastro";
	}
	
	@GetMapping("/listar")
	public String listarFuncionario() {
		return "/funcionario/lista";
	}

	@PostMapping("/salvar")
	public String salvar(@Valid Funcionario funcionario, BindingResult result, RedirectAttributes attributes){
		if(result.hasErrors()){
			return "/funcionario/cadastro";
		}
		funcionarioService.salvar(funcionario);
		attributes.addFlashAttribute("sucess", "Funcionario Inserido com sucesso");
		return "redirect:/funcionario/cadastro";
	}

}
