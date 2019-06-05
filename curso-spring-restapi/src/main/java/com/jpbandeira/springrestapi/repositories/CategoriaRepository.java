package com.jpbandeira.springrestapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpbandeira.springrestapi.domain.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer>{

}
