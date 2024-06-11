package com.academic.sistemagestionacademica.service.impl;

import com.academic.sistemagestionacademica.model.Alumno;
import com.academic.sistemagestionacademica.persistence.IAlumnoDAO;
import com.academic.sistemagestionacademica.service.IAlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlumnoServiceImpl implements IAlumnoService {

    @Autowired
    private IAlumnoDAO alumnoDAO;

    @Override
    public void save(Alumno alumno) {
        alumnoDAO.save(alumno);
    }

    @Override
    public List<Alumno> findAll() {
        return alumnoDAO.findAll();
    }

    @Override
    public Alumno findById(Long id) {
        return alumnoDAO.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        alumnoDAO.deleteById(id);
    }
}
