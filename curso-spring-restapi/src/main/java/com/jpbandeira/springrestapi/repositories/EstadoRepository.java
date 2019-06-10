
package com.jpbandeira.springrestapi.repositories;

import com.jpbandeira.springrestapi.domain.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long> {
}