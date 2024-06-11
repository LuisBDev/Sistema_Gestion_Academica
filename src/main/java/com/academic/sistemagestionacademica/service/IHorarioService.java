package com.academic.sistemagestionacademica.service;

import com.academic.sistemagestionacademica.model.Horario;

import java.util.List;

public interface IHorarioService {
    public void save(Horario horario);

    public List<Horario> findAll();

    public Horario findById(Long id);

    public void deleteById(Long id);
}
