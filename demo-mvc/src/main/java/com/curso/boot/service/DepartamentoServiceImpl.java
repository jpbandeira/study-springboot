package com.curso.boot.service;

import com.curso.boot.dao.DepartamentoDao;
import com.curso.boot.domain.Departamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = false)
@Service
public class DepartamentoServiceImpl implements DepartamentoService {

    @Autowired
    private DepartamentoDao departamentoDao;

    @Override
    public void salvar(Departamento departamento) {
        departamentoDao.save(departamento);
    }

    @Override
    public void excluir(Departamento departamento) {
        departamentoDao.delete(departamento);
    }

    @Override
    public void editar(Departamento departamento) {
        departamentoDao.update(departamento);
    }

    @Override @Transactional(readOnly = true)
    public Departamento buscarPorId(Long id) {
        return departamentoDao.findById(id);
    }

    @Override @Transactional(readOnly = true)
    public List<Departamento> buscarTodos() {
        return departamentoDao.findAll();
    }
}
