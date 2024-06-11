package com.academic.sistemagestionacademica.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String codigo;
    private String nombre;
    private Integer numeroModulos;
    private Integer horasDictadas;
    private Integer horasCertificadas;
    private Double pagoHora;

    @OneToMany(mappedBy = "curso")
    private List<Grupo> grupos;
}
