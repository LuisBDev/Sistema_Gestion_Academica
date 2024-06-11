package com.academic.sistemagestionacademica.persistence;

import com.academic.sistemagestionacademica.model.Matricula;

import java.util.List;

public interface IMatriculaDAO {
    public void save(Matricula matricula);

    public List<Matricula> findAll();

    public Matricula findById(Long id);

    public void deleteById(Long id);
}
