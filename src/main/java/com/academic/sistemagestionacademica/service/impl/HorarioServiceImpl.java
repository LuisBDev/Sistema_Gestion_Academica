package com.academic.sistemagestionacademica.service.impl;

import com.academic.sistemagestionacademica.model.Horario;
import com.academic.sistemagestionacademica.persistence.IHorarioDAO;
import com.academic.sistemagestionacademica.service.IHorarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HorarioServiceImpl implements IHorarioService {

    @Autowired
    private IHorarioDAO horarioDAO;


    @Override
    public void save(Horario horario) {
        horarioDAO.save(horario);
    }

    @Override
    public List<Horario> findAll() {
        return horarioDAO.findAll();
    }

    @Override
    public Horario findById(Long id) {
        return horarioDAO.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        horarioDAO.deleteById(id);
    }
}
