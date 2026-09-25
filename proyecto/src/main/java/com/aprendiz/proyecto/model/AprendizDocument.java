package com.aprendiz.proyecto.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "aprendiz")
public class AprendizDocument {
    @Id
    private String id;

    private String primerNombre;
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;
    private String correo;
    private String celular;
    private String direccion;
    private String cedula;
    private String tipoDePrograma;
    private String programa;
    private String ficha;
    private String regional;
}
