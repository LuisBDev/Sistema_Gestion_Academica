package com.academic.sistemagestionacademica.controller;

import com.academic.sistemagestionacademica.model.Docente;
import com.academic.sistemagestionacademica.service.IDocenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/docente")
public class DocenteController {


    @Autowired
    private IDocenteService docenteService;

    @PostMapping("/save")
    public void save(@RequestBody Docente docente) {
        docenteService.save(docente);
    }


    @GetMapping("/findAll")
    public List<Docente> findAll() {
        return docenteService.findAll();
    }

    @GetMapping("/findById/{id}")
    public Docente findById(@PathVariable Long id) {
        return docenteService.findById(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Docente docente) {
        Docente docenteToUpdate = docenteService.findById(id);
        if (docenteToUpdate != null) {
            if (docente.getFirstName() != null) {
                docenteToUpdate.setFirstName(docente.getFirstName());
            }

            if (docente.getLastName() != null) {
                docenteToUpdate.setLastName(docente.getLastName());
            }

            if (docente.getDni() != null) {
                docenteToUpdate.setDni(docente.getDni());
            }
            if (docente.getEmail() != null) {
                docenteToUpdate.setEmail(docente.getEmail());
            }
            if (docente.getTelefono() != null) {
                docenteToUpdate.setTelefono(docente.getTelefono());
            }
            if (docente.getAddress() != null) {
                docenteToUpdate.setAddress(docente.getAddress());
            }
            docenteService.save(docenteToUpdate);
            return ResponseEntity.ok().body("Docente actualizado");
        } else {
            return ResponseEntity.badRequest().body("Docente no encontrado");
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Docente docenteToDelete = docenteService.findById(id);
        if (docenteToDelete != null) {
            docenteService.deleteById(id);
            return ResponseEntity.ok().body("Docente eliminado");
        } else {
            return ResponseEntity.badRequest().body("Docente no encontrado");
        }
    }

}
