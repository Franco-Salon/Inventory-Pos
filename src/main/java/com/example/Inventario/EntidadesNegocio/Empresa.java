package com.example.Inventario.EntidadesNegocio;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.*;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "empresa")
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El campo es requirido")
    private String nombre;

    @NotBlank(message = "El campo es requirido")
    private String NIT;

    @NotBlank(message = "El campo es requirido")
    private String NRC;

    @NotBlank(message = "El campo es requirido")
    @Column(name = "Codigo de Actividad")
    private String codActividad;

    @NotBlank(message = "El campo es requirido")
    @Column(name = "Descripcion de Actividad")
    private String desActividad;


    private String nombreComercial;

    @NotBlank(message = "El campo es requirido")
    private String tipoEstablecimiento;


    private String direccion;

    @NotBlank(message = "El campo es requirido")
    private String correo;

    @ManyToOne
    @JoinColumn(name = "id_Municipio", referencedColumnName = "id")
    private Municipio municipio;





    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNIT() {
        return NIT;
    }

    public void setNIT(String NIT) {
        this.NIT = NIT;
    }

    public String getNRC() {
        return NRC;
    }

    public void setNRC(String NRC) {
        this.NRC = NRC;
    }

    public String getCodActividad() {
        return codActividad;
    }

    public void setCodActividad(String codActividad) {
        this.codActividad = codActividad;
    }

    public String getDesActividad() {
        return desActividad;
    }

    public void setDesActividad(String desActividad) {
        this.desActividad = desActividad;
    }

    public String getNombreComercial() {
        return nombreComercial;
    }

    public void setNombreComercial(String nombreComercial) {
        this.nombreComercial = nombreComercial;
    }

    public String getTipoEstablecimiento() {
        return tipoEstablecimiento;
    }

    public void setTipoEstablecimiento(String tipoEstablecimiento) {
        this.tipoEstablecimiento = tipoEstablecimiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Municipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }
}
