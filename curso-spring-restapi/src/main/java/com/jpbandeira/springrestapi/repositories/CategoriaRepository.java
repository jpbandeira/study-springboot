package com.jpbandeira.springrestapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.jpbandeira.springrestapi.domain.Categoria;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

}
