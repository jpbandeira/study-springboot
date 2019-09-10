package com.jpbandeira.springrestapi.services;

import com.jpbandeira.springrestapi.domain.Pedido;
import com.jpbandeira.springrestapi.repositories.PedidoRepository;
import javassist.tools.rmi.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository repository;

	public Pedido buscarPedido(Integer id) throws ObjectNotFoundException {
		Optional<Pedido> objetoPedido = repository.findById(id);
		return objetoPedido.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName()));
	}
}