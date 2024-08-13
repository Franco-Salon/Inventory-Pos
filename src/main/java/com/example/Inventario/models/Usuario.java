package com.example.Inventario.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "Usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El campo es requerido")
    private String nombre;

    @NotBlank(message = "El campo es requerido")
    private String correo;

    private String telefono;

    @NotBlank(message = "El campo es requerido")
    private String password;

    @NotBlank(message = "El campo es requirido")
    private long dui;

    @ManyToOne
    @JoinColumn(name = "id_Rol")
    private Rol rol;


    @ManyToOne
    @JoinColumn(name = "id_Empresa")
    private Empresa empresa;

    // Getters y Setters

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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getDui() {
        return dui;
    }

    public void setDui(long dui) {
        this.dui = dui;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
}