package com.academic.sistemagestionacademica.controller;

import com.academic.sistemagestionacademica.model.Grupo;
import com.academic.sistemagestionacademica.service.IGrupoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/grupo")
public class GrupoController {

    @Autowired
    private IGrupoService grupoService;

    @PostMapping("/save")
    public void save(@RequestBody Grupo grupo) {
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
