package com.academic.sistemagestionacademica.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Alumno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipoDocumento;
    private String numeroDocumento;
    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String email;
    private String address;
    private String phone;
    private Character genero;

    @OneToMany(mappedBy = "alumno")
    @JsonIgnore
    // TODO: Implementar DTO para evitar referencias circulares
    // TODO: Implementar ENUMs para los estados de pago
    //  (por revisar,pagado, solicitar reembolso, reembolsado, etc)
    private List<Matricula> matriculas;


}
