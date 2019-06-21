package com.jpbandeira.springrestapi.controller;

import com.jpbandeira.springrestapi.domain.Cliente;
import com.jpbandeira.springrestapi.services.ClienteService;
import javassist.tools.rmi.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> find(@PathVariable Long id) throws ObjectNotFoundException{
        Optional<Cliente> objetoCategoria = Optional.ofNullable(clienteService.buscarCliente(id));
        return ResponseEntity.ok().body(objetoCategoria);
    }
}
