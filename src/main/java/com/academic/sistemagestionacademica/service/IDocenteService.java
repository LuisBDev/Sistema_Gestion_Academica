package com.academic.sistemagestionacademica.service;

import com.academic.sistemagestionacademica.model.Docente;

import java.util.List;

public interface IDocenteService {
    public void save(Docente docente);

    public List<Docente> findAll();

    public Docente findById(Long id);

    public void deleteById(Long id);

}
