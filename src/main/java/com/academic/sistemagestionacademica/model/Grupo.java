package com.academic.sistemagestionacademica.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Grupo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String codigo;

    private String categoria;

    private String descripcion;

    private LocalDate fechaInicio;

    private LocalDate fechaFin;

    private String observacion;

    @ManyToOne
    @JoinColumn(name = "curso_id")
    @JsonIgnore
    private Curso curso;

    @ManyToOne
    @JoinColumn(name = "horario_id")
    private Horario horario;

    @OneToMany(mappedBy = "grupo")
    @JsonIgnore
    private List<Matricula> matriculas;

    @ManyToOne
    @JoinColumn(name = "docente_id")
    private Docente docente;

}

