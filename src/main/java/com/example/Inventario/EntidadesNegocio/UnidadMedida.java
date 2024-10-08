package com.example.Inventario.EntidadesNegocio;

import jakarta.persistence.*;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.NotBlank;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "unidadMedida")
public class UnidadMedida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El campo es requerido")
    private String codigo;

    @NotBlank(message = "El campo es requerido")
    private String nombre;



    // Getters y Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}