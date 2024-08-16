package com.example.Inventario.EntidadesNegocio;


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
@Table(name = "carritoCompra")
public class CarritoCompra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "el campo es requerida")
    private String codigo;

    @ManyToOne
    @JoinColumn(name = "id_Cliente")
    private Cliente cliente;


    private BigDecimal subTotal;

    private BigDecimal totalPago;

    private BigDecimal totallva;

    @NotBlank(message = "el campo es requerida")
    private String formaPago;

    @NotNull(message = "La fecha de vencimiento es requerida")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fecha;

    @NotBlank(message = "el campo es requerida")
    private Byte estatus;

    @ManyToOne
    @JoinColumn(name = "id_Empresa", referencedColumnName = "id")
    private Empresa empresa;



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

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public BigDecimal getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(BigDecimal subTotal) {
        this.subTotal = subTotal;
    }

    public BigDecimal getTotalPago() {
        return totalPago;
    }

    public void setTotalPago(BigDecimal totalPago) {
        this.totalPago = totalPago;
    }

    public BigDecimal getTotallva() {
        return totallva;
    }

    public void setTotallva(BigDecimal totallva) {
        this.totallva = totallva;
    }

    public String getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Byte getEstatus() {
        return estatus;
    }

    public void setEstatus(Byte estatus) {
        this.estatus = estatus;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
}
