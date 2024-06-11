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
public class Docente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String dni;
    private String firstName;
    private String lastName;
    private String telefono;
    private String email;
    private String address;

    @OneToMany(mappedBy = "docente")
    private List<Grupo> grupos;


}
