package com.academic.sistemagestionacademica.repository;

import com.academic.sistemagestionacademica.model.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAlumnoRepository extends JpaRepository<Alumno, Long> {
}
