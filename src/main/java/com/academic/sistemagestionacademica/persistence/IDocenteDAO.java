package com.academic.sistemagestionacademica.persistence;

import com.academic.sistemagestionacademica.model.Docente;

import java.util.List;

public interface IDocenteDAO {

    public void save(Docente docente);

    public List<Docente> findAll();

    public Docente findById(Long id);

    public void deleteById(Long id);
    
}
