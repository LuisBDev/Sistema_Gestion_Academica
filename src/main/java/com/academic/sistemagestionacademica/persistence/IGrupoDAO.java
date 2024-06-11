package com.academic.sistemagestionacademica.persistence;

import com.academic.sistemagestionacademica.model.Grupo;

import java.util.List;

public interface IGrupoDAO {

    public void save(Grupo grupo);

    public List<Grupo> findAll();

    public Grupo findById(Long id);

    public void deleteById(Long id);

}
