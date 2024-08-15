package com.example.Inventario.EntidadesNegocio;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Compra")
public class Compra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_Proveedor", referencedColumnName = "id")
    private proveedor Proveedor;

    private BigDecimal total;

    private BigDecimal totallva;

    private LocalDate fecha;

    private int codigoGenracion;

    private String tipoFactura;

    @ManyToOne
    @JoinColumn(name = "id_Usuario", referencedColumnName = "id")
    private Usuario usuario;

    private String formaPago;

    @ManyToOne
    @JoinColumn(name = "id_Empresa", referencedColumnName = "id")
    private Empresa empresa;

    @OneToMany(mappedBy = "compra")
    private Set<CompraDetalle> compradetalle = new HashSet<>();

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public proveedor getProveedor() {
        return Proveedor;
    }

    public void setProveedor(proveedor proveedor) {
        Proveedor = proveedor;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public BigDecimal getTotallva() {
        return totallva;
    }

    public void setTotallva(BigDecimal totallva) {
        this.totallva = totallva;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public int getCodigoGenracion() {
        return codigoGenracion;
    }

    public void setCodigoGenracion(int codigoGenracion) {
        this.codigoGenracion = codigoGenracion;
    }

    public String getTipoFactura() {
        return tipoFactura;
    }

    public void setTipoFactura(String tipoFactura) {
        this.tipoFactura = tipoFactura;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario)
    {
        this.usuario = usuario;
    }

    public String getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
}
