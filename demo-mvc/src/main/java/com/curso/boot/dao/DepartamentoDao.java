package com.curso.boot.dao;

import java.util.List;

import com.curso.boot.domain.Departamento;

public interface DepartamentoDao {
	
	void save(Departamento departamento);
	
	void update(Departamento departamento);
	
	void delete(Departamento departamento);
	
	Departamento findById(Long id);
	
	List<Departamento> findAll();

}
