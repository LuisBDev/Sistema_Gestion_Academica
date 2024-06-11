package com.academic.sistemagestionacademica.persistence.impl;

import com.academic.sistemagestionacademica.model.Alumno;
import com.academic.sistemagestionacademica.persistence.IAlumnoDAO;
import com.academic.sistemagestionacademica.repository.IAlumnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AlumnoDAOImpl implements IAlumnoDAO {

    @Autowired
    private IAlumnoRepository alumnoRepository;

    @Override
    public void save(Alumno alumno) {
        alumnoRepository.save(alumno);
    }

    @Override
    public List<Alumno> findAll() {
        return alumnoRepository.findAll();
    }

    @Override
    public Alumno findById(Long id) {
        return alumnoRepository.findById(id).orElse(null);
    }


    @Override
    public void deleteById(Long id) {
        alumnoRepository.deleteById(id);
    }
}
