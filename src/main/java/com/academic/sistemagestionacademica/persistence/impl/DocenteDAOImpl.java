package com.academic.sistemagestionacademica.persistence.impl;

import com.academic.sistemagestionacademica.model.Docente;
import com.academic.sistemagestionacademica.persistence.IDocenteDAO;
import com.academic.sistemagestionacademica.repository.IDocenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DocenteDAOImpl implements IDocenteDAO {

    @Autowired
    private IDocenteRepository docenteRepository;

    @Override
    public void save(Docente docente) {
        docenteRepository.save(docente);
    }

    @Override
    public List<Docente> findAll() {
        return docenteRepository.findAll();
    }

    @Override
    public Docente findById(Long id) {
        return docenteRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        docenteRepository.deleteById(id);
    }
}

