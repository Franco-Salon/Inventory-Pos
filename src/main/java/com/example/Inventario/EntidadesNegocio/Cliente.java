package com.example.Inventario.EntidadesNegocio;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El campo es requerido")
    private String tipoDocumento;

    @NotBlank(message = "El campo es requerido")
    private int numeroDocumento;

    private String nrc;

    @NotBlank(message = "El campo es requerido")
    private String nombre;

    private String codActividad;

    private String desActividad;

    @ManyToOne
    @JoinColumn(name = "id_Municipio", referencedColumnName = "id")
    private Municipio municipio;

    private String telefono;

    @NotBlank(message = "El campo es requerido")
    private String correo;

    @NotBlank(message = "El campo es requerido")
    private String password;

    @ManyToOne
    @JoinColumn(name = "id_Empresa", referencedColumnName = "id")
    private Empresa empresa;

    @OneToMany(mappedBy = "cliente")
    private Set<Cita> cita = new HashSet<>();

    @OneToMany(mappedBy = "cliente")
    private Set<CarritoCompra> carritocompra = new HashSet<>();

    @OneToMany(mappedBy = "cliente")
    private Set<Venta> venta = new HashSet<>();

    // Getters y Setters



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public int getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(int numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getNrc() {
        return nrc;
    }

    public void setNrc(String nrc) {
        this.nrc = nrc;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Municipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
}