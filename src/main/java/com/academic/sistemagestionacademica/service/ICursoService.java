package com.academic.sistemagestionacademica.service;

import com.academic.sistemagestionacademica.model.Curso;

import java.util.List;

public interface ICursoService {
    public void save(Curso curso);

    public List<Curso> findAll();

    public Curso findById(Long id);

    public void deleteById(Long id);
}
