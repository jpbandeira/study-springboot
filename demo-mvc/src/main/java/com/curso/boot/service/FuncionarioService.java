package com.curso.boot.service;

import com.curso.boot.domain.Funcionario;

import java.util.List;

public interface FuncionarioService {

    void salvar(Funcionario funcionario);
    void excluir(Funcionario funcionario);
    void editar(Funcionario funcionario);

    Funcionario buscarPorId(Long id);

    List<Funcionario> buscarTodos();

}
