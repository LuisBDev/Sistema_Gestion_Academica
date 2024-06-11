package com.academic.sistemagestionacademica.controller;

import com.academic.sistemagestionacademica.model.Curso;
import com.academic.sistemagestionacademica.service.ICursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/curso")
public class CursoController {

    @Autowired
    private ICursoService cursoService;

    @PostMapping("/save")
    public void save(@RequestBody Curso curso) {
        cursoService.save(curso);
    }


    @GetMapping("/findAll")
    public List<Curso> findAll() {
        return cursoService.findAll();
    }

    @GetMapping("/findById/{id}")
    public Curso findById(@PathVariable Long id) {
        return cursoService.findById(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateById(@PathVariable Long id, @RequestBody Curso curso) {
        Curso cursoToUpdate = cursoService.findById(id);

        if (cursoToUpdate != null) {
            if (curso.getCodigo() != null) {
                cursoToUpdate.setCodigo(curso.getCodigo());
            }
            if (curso.getNombre() != null) {
                cursoToUpdate.setNombre(curso.getNombre());
            }
            if (curso.getNumeroModulos() != null) {
                cursoToUpdate.setNumeroModulos(curso.getNumeroModulos());
            }
            if (curso.getHorasDictadas() != null) {
                cursoToUpdate.setHorasDictadas(curso.getHorasDictadas());
            }
            if (curso.getHorasCertificadas() != null) {
                cursoToUpdate.setHorasCertificadas(curso.getHorasCertificadas());
            }
            if (curso.getPagoHora() != null) {
                cursoToUpdate.setPagoHora(curso.getPagoHora());
            }
            cursoService.save(cursoToUpdate);
            return ResponseEntity.ok().body("Curso actualizado correctamente");

        } else {
            return ResponseEntity.badRequest().body("No se encontro el curso con id: " + id);
        }

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        Curso cursoToDelete = cursoService.findById(id);
        if (cursoToDelete != null) {
            cursoService.deleteById(id);
            return ResponseEntity.ok().body("Curso eliminado correctamente");
        } else {
            return ResponseEntity.badRequest().body("No se encontro el curso con id: " + id);
        }
    }


}
