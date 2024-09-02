package com.academic.sistemagestionacademica.controller;

import com.academic.sistemagestionacademica.model.Matricula;
import com.academic.sistemagestionacademica.service.IMatriculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/matricula")
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class MatriculaController {

    @Autowired
    private IMatriculaService matriculaService;

    @PostMapping("/save")
    public void save(@RequestBody Matricula matricula) {
        matriculaService.save(matricula);
    }


    @GetMapping("/findAll")
    public List<Matricula> findAll() {
        return matriculaService.findAll();
    }

    @GetMapping("/findById/{id}")
    public Matricula findById(@PathVariable Long id) {
        return matriculaService.findById(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Matricula matricula) {
        Matricula matriculaToUpdate = matriculaService.findById(id);


        if (matriculaToUpdate != null) {
            if (matricula.getCuenta() != null) {
                matriculaToUpdate.setCuenta(matricula.getCuenta());
            }

            if (matricula.getTipoComprobante() != null) {
                matriculaToUpdate.setTipoComprobante(matricula.getTipoComprobante());
            }

            if (matricula.getMoneda() != null) {
                matriculaToUpdate.setMoneda(matricula.getMoneda());
            }

            if (matricula.getMonto() != null) {
                matriculaToUpdate.setMonto(matricula.getMonto());
            }

            if (matricula.getEstadoPago() != null) {
                matriculaToUpdate.setEstadoPago(matricula.getEstadoPago());
            }

            if (matricula.getCuentaPresupuestaria() != null) {
                matriculaToUpdate.setCuentaPresupuestaria(matricula.getCuentaPresupuestaria());
            }
            if (matricula.getNumeroOperacion() != null) {
                matriculaToUpdate.setNumeroOperacion(matricula.getNumeroOperacion());
            }

            if (matricula.getFechaPago() != null) {
                matriculaToUpdate.setFechaPago(matricula.getFechaPago());
            }

            if (matricula.getNombreBanco() != null) {
                matriculaToUpdate.setNombreBanco(matricula.getNombreBanco());
            }

            if (matricula.getObservacion() != null) {
                matriculaToUpdate.setObservacion(matricula.getObservacion());
            }

            matriculaService.save(matriculaToUpdate);
            return ResponseEntity.ok().body("Matricula actualizado");
        } else {
            return ResponseEntity.ok().body("Matricula no encontrado");
        }
    }

    @PatchMapping("/update2/{id}")
    public ResponseEntity<?> update2(@PathVariable Long id, @RequestBody Matricula matricula)
    {
        Matricula matriculaToUpdate = matriculaService.findById(id);
        if (matriculaToUpdate != null)
        {
            matricula.setId(id);
            matriculaService.save(matricula);
            return ResponseEntity.ok().body("Matricula actualizada setteando id");
        }
        else
        {
            return ResponseEntity.ok().body("Matricula no encontrado");
        }
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Matricula matriculaToDelete = matriculaService.findById(id);
        if (matriculaToDelete != null) {
            matriculaService.deleteById(id);
            return ResponseEntity.ok().body("Matricula eliminado");
        } else {
            return ResponseEntity.ok().body("Matricula no encontrado");
        }
    }

}
