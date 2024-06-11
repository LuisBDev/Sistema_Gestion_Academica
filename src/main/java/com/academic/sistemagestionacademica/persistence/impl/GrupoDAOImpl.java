package com.academic.sistemagestionacademica.persistence.impl;

import com.academic.sistemagestionacademica.model.Grupo;
import com.academic.sistemagestionacademica.persistence.IGrupoDAO;
import com.academic.sistemagestionacademica.repository.IGrupoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GrupoDAOImpl implements IGrupoDAO {

    @Autowired
    private IGrupoRepository grupoRepository;

    @Override
    public void save(Grupo grupo) {
        grupoRepository.save(grupo);
    }

    @Override
    public List<Grupo> findAll() {
        return grupoRepository.findAll();
    }

    @Override
    public Grupo findById(Long id) {
        return grupoRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        grupoRepository.deleteById(id);
    }
}
