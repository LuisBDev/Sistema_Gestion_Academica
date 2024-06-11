package com.academic.sistemagestionacademica.repository;

import com.academic.sistemagestionacademica.model.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMatriculaRepository extends JpaRepository<Matricula, Long> {
}
