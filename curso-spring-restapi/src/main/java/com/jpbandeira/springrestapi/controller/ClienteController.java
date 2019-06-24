package com.jpbandeira.springrestapi.controller;

import com.jpbandeira.springrestapi.domain.Cliente;
import com.jpbandeira.springrestapi.dto.ClienteDto;
import com.jpbandeira.springrestapi.dto.ClienteNewDto;
import com.jpbandeira.springrestapi.services.ClienteService;
import javassist.tools.rmi.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> find(@PathVariable Long id) throws ObjectNotFoundException{
        Optional<Cliente> objetoCliente = Optional.ofNullable(service.buscar(id));
        return ResponseEntity.ok().body(objetoCliente);
    }

    @GetMapping()
    public ResponseEntity<List<ClienteDto>> findAll() throws ObjectNotFoundException {
        List<Cliente> categoriaList = service.findAll();
        List<ClienteDto> categoriaDtoList = categoriaList.stream().map(objeto -> new ClienteDto(objeto)).collect(Collectors.toList());
        return ResponseEntity.ok().body(categoriaDtoList);
    }

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody ClienteNewDto objetoDto){
        Cliente objeto = service.fromDTO(objetoDto);
        objeto = service.insert(objeto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(objeto.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping()
    public ResponseEntity<Void> update(@Valid @RequestBody Cliente objetoCliente) throws ObjectNotFoundException {
        System.out.println(objetoCliente.toString());
        service.update(objetoCliente);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return  ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/page")
    public ResponseEntity<Page<ClienteDto>> findPage(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                                       @RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
                                                       @RequestParam(value = "orderBy", defaultValue = "nome") String orderBy,
                                                       @RequestParam(value = "direction", defaultValue = "ASC") String direction){
        Page<Cliente> categoriaList = service.findPage(page, linesPerPage, orderBy, direction);
        Page<ClienteDto> categoriaDtoList = categoriaList.map(objeto -> new ClienteDto(objeto));
        return ResponseEntity.ok().body(categoriaDtoList);
    }
}
