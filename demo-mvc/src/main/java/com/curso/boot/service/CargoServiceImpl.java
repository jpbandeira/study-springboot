package com.curso.boot.service;

import com.curso.boot.dao.CargoDao;
import com.curso.boot.domain.Cargo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CargoServiceImpl implements CargoService {

    @Autowired
    private CargoDao cargoDao;

    @Override @Transactional(readOnly = false)
    public void salvar(Cargo cargo) {
        cargoDao.save(cargo);
    }

    @Override @Transactional(readOnly = false)
    public void excluir(Cargo cargo) {
        cargoDao.delete(cargo);
    }

    @Override @Transactional(readOnly = false)
    public void editar(Cargo cargo) {
        cargoDao.update(cargo);
    }

    @Override @Transactional(readOnly = true)
    public Cargo buscarPorId(Long id) {
        return cargoDao.findById(id);
    }

    @Override @Transactional(readOnly = true)
    public List<Cargo> buscarTodos() {
        return cargoDao.findAll();
    }
}
