package com.example.Inventario.EntidadesNegocio;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El campo es requerido")
    private String nombre;

    private String correlativo;

    private String descripcion;

    @NotBlank(message = "El campo es requerido")
    private int existencia;

    @NotBlank(message = "El campo es requerido")
    private BigDecimal precio;

    @ManyToOne
    @JoinColumn(name = "id_Empresa")
    private Empresa empresa;

    @NotBlank(message = "El campo es requerido")
    private String codigoBarra;

    @NotNull(message = "La fecha de vencimiento es requerida")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fecha;

    @ManyToOne
    @JoinColumn(name = "id_Categoria", referencedColumnName = "id")
    private CategoriaItem categoriaitem;

    @ManyToOne
    @JoinColumn(name = "id_tipoitem", referencedColumnName = "id")
    private TipoItem tipoitem;


    // Referencia De Tablas Item - ItemProveedor:
    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<ItemProveedor> itemProveedores = new HashSet<>();

    //  Accesors Item - ItemProveedor:
    public Set<ItemProveedor> getItemProveedores()
    {
        return itemProveedores;
    }
    public void setItemProveedores(Set<ItemProveedor> itemProveedores)
    {
        this.itemProveedores = itemProveedores;
    }


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

    public String getCorrelativo() {
        return correlativo;
    }

    public void setCorrelativo(String correlativo) {
        this.correlativo = correlativo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getExistencia() {
        return existencia;
    }

    public void setExistencia(int existencia) {
        this.existencia = existencia;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public String getCodigoBarra() {
        return codigoBarra;
    }

    public void setCodigoBarra(String codigoBarra) {
        this.codigoBarra = codigoBarra;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public CategoriaItem getCategoriaitem() {
        return categoriaitem;
    }

    public void setCategoriaitem(CategoriaItem categoriaitem) {
        this.categoriaitem = categoriaitem;
    }

    public TipoItem getTipoitem() {
        return tipoitem;
    }

    public void setTipoitem(TipoItem tipoitem) {
        this.tipoitem = tipoitem;
    }
}