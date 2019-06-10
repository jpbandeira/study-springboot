package com.jpbandeira.springrestapi.resources.exception;

import com.jpbandeira.springrestapi.domain.Pedido;
import com.jpbandeira.springrestapi.services.PedidoService;
import javassist.tools.rmi.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoResource {
	
	@Autowired
	private PedidoService pedidoService;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<?> find(@PathVariable Long id) throws ObjectNotFoundException {
		Optional<Pedido> objetoCategoria = Optional.ofNullable(pedidoService.buscarPedido(id));
		return ResponseEntity.ok().body(objetoCategoria);
	}
}