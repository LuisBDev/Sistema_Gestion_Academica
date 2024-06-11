package com.academic.sistemagestionacademica.persistence.impl;

import com.academic.sistemagestionacademica.model.Curso;
import com.academic.sistemagestionacademica.persistence.ICursoDAO;
import com.academic.sistemagestionacademica.repository.ICursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CursoDAOImpl implements ICursoDAO {

    @Autowired
    ICursoRepository cursoRepository;


    @Override
    public void save(Curso curso) {
        cursoRepository.save(curso);
    }

    @Override
    public List<Curso> findAll() {
        return cursoRepository.findAll();
    }

    @Override
    public Curso findById(Long id) {
        return cursoRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        cursoRepository.deleteById(id);
    }
}
