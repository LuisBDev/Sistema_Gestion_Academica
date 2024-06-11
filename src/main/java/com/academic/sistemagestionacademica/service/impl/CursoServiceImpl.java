package com.academic.sistemagestionacademica.service.impl;

import com.academic.sistemagestionacademica.model.Curso;
import com.academic.sistemagestionacademica.persistence.ICursoDAO;
import com.academic.sistemagestionacademica.service.ICursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoServiceImpl implements ICursoService {

    @Autowired
    private ICursoDAO cursoDAO;

    @Override
    public void save(Curso curso) {
        cursoDAO.save(curso);
    }

    @Override
    public List<Curso> findAll() {
        return cursoDAO.findAll();
    }

    @Override
    public Curso findById(Long id) {
        return cursoDAO.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        cursoDAO.deleteById(id);
    }
}
