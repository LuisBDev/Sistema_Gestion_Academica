package com.academic.sistemagestionacademica.repository;

import com.academic.sistemagestionacademica.model.Grupo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IGrupoRepository extends JpaRepository<Grupo, Long> {

    @Query("SELECT g FROM Grupo g WHERE g.curso.nombre = ?1")
    List<Grupo> findGruposPorCurso(String nombreCurso);

}
