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

            alumno.getMatriculas().add(matricula);
            grupoService.save(grupo);
            alumnoService.save(alumno);
            matriculaService.save(matricula);
            return ResponseEntity.ok("Matricula realizada correctamente");
        }


    }

}
