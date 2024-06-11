package com.academic.sistemagestionacademica.service.impl;

import com.academic.sistemagestionacademica.model.Grupo;
import com.academic.sistemagestionacademica.persistence.IGrupoDAO;
import com.academic.sistemagestionacademica.service.IGrupoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GrupoServiceImpl implements IGrupoService {

    @Autowired
    private IGrupoDAO grupoDAO;

    @Override
    public void save(Grupo grupo) {
        grupoDAO.save(grupo);
    }

    @Override
    public List<Grupo> findAll() {
        return grupoDAO.findAll();
    }

    @Override
    public Grupo findById(Long id) {
        return grupoDAO.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        grupoDAO.deleteById(id);
    }
}
