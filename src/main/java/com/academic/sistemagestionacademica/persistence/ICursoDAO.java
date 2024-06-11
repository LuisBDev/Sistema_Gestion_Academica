package com.academic.sistemagestionacademica.persistence;

import com.academic.sistemagestionacademica.model.Curso;

import java.util.List;

public interface ICursoDAO {


    public void save(Curso curso);

    public List<Curso> findAll();

    public Curso findById(Long id);

    public void deleteById(Long id);
}
