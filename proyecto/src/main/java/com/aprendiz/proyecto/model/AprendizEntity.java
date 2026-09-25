package com.aprendiz.proyecto.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity (name = "aprendiz")
public class AprendizEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "primer_nombre")
    private String primerNombre;

    @Column(name = "segundo_nombre")
    private String segundoNombre;

    @Column(name = "primer_apellido")
    private String primerApellido;

    @Column(name = "segundo_apellido")
    private String segundoApellido;

    @Column(name = "correo", unique = true)
    private String correo;

    @Column(name = "celular")
    private String celular;

    @Column(name = "direccion")
    private String direccion;

    @Column (name = "cedula", unique = true)
    private String cedula;

    @Column(name = "tipo_de_programa")
    private String tipoDePrograma;

    @Column (name = "programa")
    private String programa;

    @Column (name = "ficha")
    private String ficha;

    @Column (name = "regional")
    private String regional;
}
