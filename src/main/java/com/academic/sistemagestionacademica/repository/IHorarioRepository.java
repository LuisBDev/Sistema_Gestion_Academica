package com.academic.sistemagestionacademica.repository;

import com.academic.sistemagestionacademica.model.Horario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IHorarioRepository extends JpaRepository<Horario, Long> {
}
