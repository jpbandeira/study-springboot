package com.curso.boot.service;

import com.curso.boot.domain.Cargo;

import java.util.List;

public interface CargoService {

    void salvar(Cargo cargo);
    void excluir(Cargo cargo);
    void editar(Cargo cargo);

    Cargo buscarPorId(Long id);

    List<Cargo> buscarTodos();

}
