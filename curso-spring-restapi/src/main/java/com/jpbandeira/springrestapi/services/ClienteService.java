package com.jpbandeira.springrestapi.services;

import com.jpbandeira.springrestapi.domain.Cidade;
import com.jpbandeira.springrestapi.domain.Cliente;
import com.jpbandeira.springrestapi.domain.Endereco;
import com.jpbandeira.springrestapi.dto.ClienteDto;
import com.jpbandeira.springrestapi.dto.ClienteNewDto;
import com.jpbandeira.springrestapi.enums.TipoCliente;
import com.jpbandeira.springrestapi.repositories.ClienteRepository;
import javassist.tools.rmi.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    public Cliente buscar(Long id) throws ObjectNotFoundException {
        Optional<Cliente> objeto = repository.findById(id);
        return objeto.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
    }

    public Cliente update(Cliente objeto) throws ObjectNotFoundException {
        Cliente newObj = buscar(objeto.getId());
        updateData(newObj, objeto);
        return repository.save(objeto);
    }

    private void updateData(Cliente newObj, Cliente obj) {
        newObj.setNome(obj.getNome());
        newObj.setEmail(obj.getEmail());
    }

    @Transactional
    public Cliente insert(Cliente objeto) {
        objeto.setId(null);
        return objeto =  repository.save(objeto);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public List<Cliente> findAll() {
        return repository.findAll();
    }

    public Page<Cliente> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
        PageRequest pageRequest  = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        return repository.findAll(pageRequest);
    }

    public Cliente fromDTO(ClienteDto objDto) {
        return new Cliente(objDto.getId(), objDto.getNome(), objDto.getEmail(), null, null);
    }

    public Cliente fromDTO(ClienteNewDto objDto) {
        Cliente cliente = new Cliente(null, objDto.getNome(), objDto.getEmail(), objDto.getCpfOuCnpj(), TipoCliente.toEnum(objDto.getTipoCliente()));
        Cidade cidade = new Cidade(objDto.getCidadeId(), null, null);
        Endereco endereco = new Endereco(null, objDto.getLogadouro(), objDto.getNumero(), objDto.getComplemento(), objDto.getBairro(), objDto.getCep(), cliente, cidade);
        cliente.getEnderecos().add(endereco);
        cliente.getTelefones().add(objDto.getTelefone1());
        if(objDto.getTelefone2() != null){
            cliente.getTelefones().add(objDto.getTelefone2());
        }
        if(objDto.getTelefone3() != null){
            cliente.getTelefones().add(objDto.getTelefone3());
        }
        return cliente;
    }
}
