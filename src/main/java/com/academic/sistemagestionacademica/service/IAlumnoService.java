package com.academic.sistemagestionacademica.service;

import com.academic.sistemagestionacademica.model.Alumno;

import java.util.List;

public interface IAlumnoService {
    public void save(Alumno alumno);

    public List<Alumno> findAll();

    public Alumno findById(Long id);

    public void deleteById(Long id);
}
