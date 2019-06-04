package com.curso.boot.service;

import com.curso.boot.dao.FuncionarioDao;
import com.curso.boot.domain.Funcionario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = false)
@Service
public class FuncionarioServiceImpl implements FuncionarioService {

    @Autowired
    private FuncionarioDao funcionarioDao;

    @Override
    public void salvar(Funcionario funcionario) {
        funcionarioDao.save(funcionario);
    }

    @Override
    public void excluir(Funcionario funcionario) {
        funcionarioDao.delete(funcionario);
    }

    @Override
    public void editar(Funcionario funcionario) {
        funcionarioDao.update(funcionario);
    }

    @Override @Transactional(readOnly = true)
    public Funcionario buscarPorId(Long id) {
        return funcionarioDao.findById(id);
    }

    @Override @Transactional(readOnly = true)
    public List<Funcionario> buscarTodos() {
        return funcionarioDao.findAll();
    }
}
