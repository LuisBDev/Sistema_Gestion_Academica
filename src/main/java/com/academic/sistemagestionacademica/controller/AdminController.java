package com.academic.sistemagestionacademica.controller;

import com.academic.sistemagestionacademica.model.Alumno;
import com.academic.sistemagestionacademica.model.Grupo;
import com.academic.sistemagestionacademica.model.Matricula;
import com.academic.sistemagestionacademica.service.IAlumnoService;
import com.academic.sistemagestionacademica.service.IGrupoService;
import com.academic.sistemagestionacademica.service.IMatriculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private IGrupoService grupoService;

    @Autowired
    private IAlumnoService alumnoService;

    @Autowired
    private IMatriculaService matriculaService;

    @PostMapping("/matricular/{alumnoId}/{grupoId}")
    public ResponseEntity<?> matricular(@RequestBody Matricula matricula, @PathVariable Long alumnoId, @PathVariable Long grupoId) {

        Alumno alumno = alumnoService.findById(alumnoId);
        Grupo grupo = grupoService.findById(grupoId);
        //Verificar si el alumno ya esta matriculado en el grupo
        if (alumno.getMatriculas().stream().anyMatch(matricula1 -> matricula1.getGrupo().getId().equals(grupoId))) {
            return ResponseEntity.badRequest().body("El alumno ya esta matriculado en el grupo");
        } else {
            matricula.setAlumno(alumno);
            matricula.setGrupo(grupo);
            grupo.getMatriculas().add(matricula);
            grupo.setNumeroMatriculados(grupo.getNumeroMatriculados()+1);

            alumno.getMatriculas().add(matricula);
            grupoService.save(grupo);
            alumnoService.save(alumno);
            matriculaService.save(matricula);
            return ResponseEntity.ok("Matricula realizada correctamente");
        }
    }


    @PutMapping("/transferirMatricula/{alumnoId}/{grupoAntiguoId}/{grupoNuevoId}")
    public ResponseEntity<?> transferirMatricula(@PathVariable Long alumnoId, @PathVariable Long grupoAntiguoId, @PathVariable Long grupoNuevoId) {
        Alumno alumno = alumnoService.findById(alumnoId);
        Grupo grupoAntiguo = grupoService.findById(grupoAntiguoId);
        Grupo grupoNuevo = grupoService.findById(grupoNuevoId);


        if (alumno.getMatriculas().stream().anyMatch(matricula1 -> matricula1.getGrupo().getId().equals(grupoNuevoId))) {
            return ResponseEntity.badRequest().body("El alumno ya esta matriculado en el grupo");
        } else {
            Matricula matricula = alumno.getMatriculas().stream().filter(matricula1 -> matricula1.getGrupo().getId().equals(grupoAntiguoId)).findFirst().orElse(null);
            if (matricula != null) {
                matricula.setGrupo(grupoNuevo);
                grupoAntiguo.getMatriculas().remove(matricula);
                grupoNuevo.getMatriculas().add(matricula);
                grupoAntiguo.setNumeroMatriculados(grupoAntiguo.getNumeroMatriculados()-1);
                grupoNuevo.setNumeroMatriculados(grupoNuevo.getNumeroMatriculados()+1);
                grupoService.save(grupoAntiguo);
                grupoService.save(grupoNuevo);
                matriculaService.save(matricula);
                return ResponseEntity.ok("Matricula transferida correctamente");
            } else {
                return ResponseEntity.badRequest().body("El alumno no esta matriculado en el grupo antiguo");
            }
        }
    }

}
