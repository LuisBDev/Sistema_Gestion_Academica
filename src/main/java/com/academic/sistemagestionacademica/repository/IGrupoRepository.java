package com.academic.sistemagestionacademica.repository;

import com.academic.sistemagestionacademica.model.Grupo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IGrupoRepository extends JpaRepository<Grupo, Long> {
}
