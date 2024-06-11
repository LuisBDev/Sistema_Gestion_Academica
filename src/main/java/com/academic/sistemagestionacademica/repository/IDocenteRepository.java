package com.academic.sistemagestionacademica.repository;

import com.academic.sistemagestionacademica.model.Docente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDocenteRepository extends JpaRepository<Docente, Long> {
}
