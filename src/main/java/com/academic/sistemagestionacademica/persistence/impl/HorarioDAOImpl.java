package com.academic.sistemagestionacademica.persistence.impl;

import com.academic.sistemagestionacademica.model.Horario;
import com.academic.sistemagestionacademica.persistence.IHorarioDAO;
import com.academic.sistemagestionacademica.repository.IHorarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HorarioDAOImpl implements IHorarioDAO {

    @Autowired
    private IHorarioRepository horarioRepository;


    @Override
    public void save(Horario horario) {
        horarioRepository.save(horario);
    }

    @Override
    public List<Horario> findAll() {
        return horarioRepository.findAll();
    }

    @Override
    public Horario findById(Long id) {
        return horarioRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        horarioRepository.deleteById(id);
    }
}
