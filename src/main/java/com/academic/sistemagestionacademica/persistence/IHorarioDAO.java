package com.academic.sistemagestionacademica.persistence;

import com.academic.sistemagestionacademica.model.Horario;

import java.util.List;

public interface IHorarioDAO {
    public void save(Horario horario);

    public List<Horario> findAll();

    public Horario findById(Long id);

    public void deleteById(Long id);
}
