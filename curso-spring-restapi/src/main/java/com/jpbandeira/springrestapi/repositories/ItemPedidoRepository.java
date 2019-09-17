package com.jpbandeira.springrestapi.repositories;

import com.jpbandeira.springrestapi.domain.Categoria;
import com.jpbandeira.springrestapi.domain.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Integer> {

}
