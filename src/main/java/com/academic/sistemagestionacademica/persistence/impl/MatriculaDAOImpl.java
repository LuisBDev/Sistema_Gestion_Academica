package com.academic.sistemagestionacademica.persistence.impl;

import com.academic.sistemagestionacademica.model.Matricula;
import com.academic.sistemagestionacademica.persistence.IMatriculaDAO;
import com.academic.sistemagestionacademica.repository.IMatriculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MatriculaDAOImpl implements IMatriculaDAO {

    @Autowired
    private IMatriculaRepository matriculaRepository;

    @Override
    public void save(Matricula matricula) {
        matriculaRepository.save(matricula);
    }

    @Override
    public List<Matricula> findAll() {
        return matriculaRepository.findAll();
    }

    @Override
    public Matricula findById(Long id) {
        return matriculaRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        matriculaRepository.deleteById(id);
    }
}
