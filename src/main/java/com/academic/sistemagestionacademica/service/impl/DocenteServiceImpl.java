package com.academic.sistemagestionacademica.service.impl;

import com.academic.sistemagestionacademica.model.Docente;
import com.academic.sistemagestionacademica.persistence.IDocenteDAO;
import com.academic.sistemagestionacademica.service.IDocenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocenteServiceImpl implements IDocenteService {

    @Autowired
    private IDocenteDAO docenteDAO;

    @Override
    public void save(Docente docente) {
        docenteDAO.save(docente);
    }

    @Override
    public List<Docente> findAll() {
        return docenteDAO.findAll();
    }

    @Override
    public Docente findById(Long id) {
        return docenteDAO.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        docenteDAO.deleteById(id);
    }
}
