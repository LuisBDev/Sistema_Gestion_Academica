package com.academic.sistemagestionacademica.controller;

import com.academic.sistemagestionacademica.model.Grupo;
import com.academic.sistemagestionacademica.service.ICursoService;
import com.academic.sistemagestionacademica.service.IDocenteService;
import com.academic.sistemagestionacademica.service.IGrupoService;
import com.academic.sistemagestionacademica.service.IHorarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/grupo")
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class GrupoController {

    @Autowired
    private IGrupoService grupoService;

    @Autowired
    private IHorarioService horarioService;

    @Autowired
    private IDocenteService docenteService;

    @Autowired
    private ICursoService cursoService;

    @PostMapping("/save/{horarioId}/{docenteId}/{cursoId}")
    public void save(@RequestBody Grupo grupo, @PathVariable Long horarioId, @PathVariable Long docenteId, @PathVariable Long cursoId) {
        grupo.setHorario(horarioService.findById(horarioId));
        grupo.setDocente(docenteService.findById(docenteId));
        grupo.setCurso(cursoService.findById(cursoId));
        grupo.setNumeroMatriculados(0);
        grupoService.save(grupo);
    }

    @GetMapping("/findAll")
    public List<Grupo> findAll() {
        return grupoService.findAll();
    }

    @GetMapping("/findById/{id}")
    public Grupo findById(@PathVariable Long id) {
        return grupoService.findById(id);
    }

    @GetMapping("/findGrupos/{nombreCurso}")
    public List<Grupo> findGruposPorCurso(@PathVariable String nombreCurso) {
        return grupoService.findGruposPorCurso(nombreCurso);
    }



    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Grupo grupo) {
        Grupo grupoToUpdate = grupoService.findById(id);
        if (grupoToUpdate != null) {
            if (grupo.getNombre() != null) {
                grupoToUpdate.setNombre(grupo.getNombre());
            }
            if (grupo.getCodigo() != null) {
                grupoToUpdate.setCodigo(grupo.getCodigo());
            }
            if (grupo.getCategoria() != null) {
                grupoToUpdate.setCategoria(grupo.getCategoria());
            }
            if (grupo.getDescripcion() != null) {
                grupoToUpdate.setDescripcion(grupo.getDescripcion());
            }

            if (grupo.getFechaInicio() != null) {
                grupoToUpdate.setFechaInicio(grupo.getFechaInicio());
            }
            if (grupo.getFechaFin() != null) {
                grupoToUpdate.setFechaFin(grupo.getFechaFin());
            }
            if (grupo.getObservacion() != null) {
                grupoToUpdate.setObservacion(grupo.getObservacion());
            }
            grupoService.save(grupoToUpdate);
            return ResponseEntity.ok().body("Grupo actualizado");
        } else {
            return ResponseEntity.badRequest().body("Grupo no encontrado");

        }
    }


}
