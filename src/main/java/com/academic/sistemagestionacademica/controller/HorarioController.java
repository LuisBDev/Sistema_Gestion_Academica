package com.academic.sistemagestionacademica.controller;

import com.academic.sistemagestionacademica.model.Horario;
import com.academic.sistemagestionacademica.service.IHorarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/horario")
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class HorarioController {

    @Autowired
    private IHorarioService horarioService;

    @PostMapping("/save")
    public void save(@RequestBody Horario horario) {
        horarioService.save(horario);
    }


    @GetMapping("/findAll")
    public List<Horario> findAll() {
        return horarioService.findAll();
    }

    @GetMapping("/findById/{id}")
    public Horario findById(@PathVariable Long id) {
        return horarioService.findById(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Horario horario) {
        Horario horarioToUpdate = horarioService.findById(id);
        if (horarioToUpdate != null) {
            if (horario.getHorario() != null) {
                horarioToUpdate.setHorario(horario.getHorario());
            }
            horarioService.save(horarioToUpdate);
            return ResponseEntity.ok().body("Horario actualizado");
        } else {
            return ResponseEntity.ok().body("Horario no encontrado");
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Horario horarioToDelete = horarioService.findById(id);
        if (horarioToDelete != null) {
            horarioService.deleteById(id);
            return ResponseEntity.ok().body("Horario eliminado");
        } else {
            return ResponseEntity.ok().body("Horario no encontrado");
        }
    }

}
