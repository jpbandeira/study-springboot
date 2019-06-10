package com.jpbandeira.springrestapi.services;

import com.jpbandeira.springrestapi.domain.Cliente;
import com.jpbandeira.springrestapi.repositories.ClienteRepository;
import javassist.tools.rmi.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente buscarCliente(Long id) throws ObjectNotFoundException {
        Optional<Cliente> objetoCategoria = clienteRepository.findById(id);
        return objetoCategoria.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
    }
}
