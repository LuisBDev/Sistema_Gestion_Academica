package com.academic.sistemagestionacademica.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Matricula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cuenta;
    private String tipoComprobante;
    private String moneda;
    private Double monto;
    private String estadoPago;
    private String cuentaPresupuestaria;
    private String numeroOperacion;
    private LocalDate fechaPago;
    private String nombreBanco;
    private String observacion;

    @ManyToOne
    @JoinColumn(name = "grupo_id")
    @JsonIgnore
    private Grupo grupo;


    @ManyToOne
    @JoinColumn(name = "alumno_id")
    private Alumno alumno;

}
