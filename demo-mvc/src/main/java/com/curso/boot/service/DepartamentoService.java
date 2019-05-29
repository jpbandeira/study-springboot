package com.curso.boot.service;

import com.curso.boot.domain.Departamento;

import java.util.List;

public interface DepartamentoService {

    void salvar(Departamento departamento);
    void excluir(Departamento departamento);
    void editar(Departamento departamento);

    Departamento buscarPorId(Long id);

    List<Departamento> buscarTodos();

}
