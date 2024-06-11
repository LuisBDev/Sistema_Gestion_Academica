package com.academic.sistemagestionacademica.persistence;

import com.academic.sistemagestionacademica.model.Alumno;

import java.util.List;

public interface IAlumnoDAO {

    public void save(Alumno alumno);

    public List<Alumno> findAll();

    public Alumno findById(Long id);

    public void deleteById(Long id);


}
