package com.academic.sistemagestionacademica.service.impl;

import com.academic.sistemagestionacademica.model.Matricula;
import com.academic.sistemagestionacademica.persistence.IMatriculaDAO;
import com.academic.sistemagestionacademica.service.IMatriculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatriculaServiceImpl implements IMatriculaService {

    @Autowired
    private IMatriculaDAO matriculaDAO;


    @Override
    public void save(Matricula matricula) {
        matriculaDAO.save(matricula);
    }

    @Override
    public List<Matricula> findAll() {
        return matriculaDAO.findAll();
    }

    @Override
    public Matricula findById(Long id) {
        return matriculaDAO.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        matriculaDAO.deleteById(id);
    }
}
