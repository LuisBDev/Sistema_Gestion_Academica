package com.academic.sistemagestionacademica.service;

import com.academic.sistemagestionacademica.model.Matricula;

import java.util.List;

public interface IMatriculaService {
    public void save(Matricula matricula);

    public List<Matricula> findAll();

    public Matricula findById(Long id);

    public void deleteById(Long id);
}
