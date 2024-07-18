package com.academic.sistemagestionacademica.controller;

import com.academic.sistemagestionacademica.model.Alumno;
import com.academic.sistemagestionacademica.service.IAlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alumno")
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class AlumnoController {

    @Autowired
    private IAlumnoService alumnoService;

    @PostMapping("/save")
    public void save(@RequestBody Alumno alumno) {
        alumnoService.save(alumno);
    }


    @GetMapping("/findAll")
    public List<Alumno> findAll() {
        return alumnoService.findAll();
    }

    @GetMapping("/findById/{id}")
    public Alumno findById(@PathVariable Long id) {
        return alumnoService.findById(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateById(@PathVariable Long id, @RequestBody Alumno alumno) {
        Alumno alumnoToUpdate = alumnoService.findById(id);
        if (alumnoToUpdate != null) {
            if (alumno.getNumeroDocumento() != null) {
                alumnoToUpdate.setNumeroDocumento(alumno.getNumeroDocumento());
            }
            if (alumno.getNombres() != null) {
                alumnoToUpdate.setNombres(alumno.getNombres());
            }
            if (alumno.getApellidoPaterno() != null) {
                alumnoToUpdate.setApellidoPaterno(alumno.getApellidoPaterno());
            }
            if (alumno.getPhone() != null) {
                alumnoToUpdate.setPhone(alumno.getPhone());
            }
            if (alumno.getEmail() != null) {
                alumnoToUpdate.setEmail(alumno.getEmail());
            }
            if (alumno.getAddress() != null) {
                alumnoToUpdate.setAddress(alumno.getAddress());
            }
            alumnoService.save(alumnoToUpdate);
            return ResponseEntity.ok().body("Alumno actualizado correctamente");
        } else {
            return ResponseEntity.badRequest().body("No se encontro el alumno con id: " + id);
        }

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        Alumno alumnoToDelete = alumnoService.findById(id);
        if (alumnoToDelete != null) {
            alumnoService.deleteById(id);
            return ResponseEntity.ok().body("Alumno eliminado correctamente");
        } else {
            return ResponseEntity.badRequest().body("No se encontro el alumno con id: " + id);
        }
    }

}
