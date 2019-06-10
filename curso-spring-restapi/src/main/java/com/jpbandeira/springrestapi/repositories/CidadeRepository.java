
package com.jpbandeira.springrestapi.repositories;

import com.jpbandeira.springrestapi.domain.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long>{
}

