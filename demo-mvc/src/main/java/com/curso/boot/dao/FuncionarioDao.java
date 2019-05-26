package com.curso.boot.dao;

import java.util.List;

import com.curso.boot.domain.Funcionario;

public interface FuncionarioDao {

	void save(Funcionario funcionario);
	
	void update(Funcionario funcionario);
	
	void delete(Funcionario funcionario);
	
	Funcionario findById(Long id);
	
	List<Funcionario> findAll();
	
}
