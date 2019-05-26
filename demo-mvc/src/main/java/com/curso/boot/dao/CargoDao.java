package com.curso.boot.dao;

import java.util.List;

import com.curso.boot.domain.Cargo;

public interface CargoDao {
	
	void save(Cargo cargo);
	
	void update(Cargo cargo);
	
	void delete(Cargo cargo);
	
	Cargo findById(Long id);
	
	List<Cargo> findAll();

}
