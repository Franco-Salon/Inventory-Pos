package com.example.Inventario.EntidadesNegocio;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "cita")
public class Cita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "id_UsuarioSolicitante", referencedColumnName = "id")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "id_UsuarioEncargado", referencedColumnName = "id")
    private Cargo cargo;

    @NotNull(message = "La fecha de vencimiento es requerida")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaSolicitada;

    private LocalTime duracionEstimada;

    private byte estatus;

    private BigDecimal total;

    @OneToMany(mappedBy = "citas")
    private Set<DetalleCita> detallecita = new HashSet<>();

    @OneToMany(mappedBy = "citas")
    private Set<Venta> venta = new HashSet<>();

    // Getters y Setters

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public LocalDate getFechaSolicitada() {
        return fechaSolicitada;
    }

    public void setFechaSolicitada(LocalDate fechaSolicitada) {
        this.fechaSolicitada = fechaSolicitada;
    }

    public LocalTime getDuracionEstimada() {
        return duracionEstimada;
    }

    public void setDuracionEstimada(LocalTime duracionEstimada) {
        this.duracionEstimada = duracionEstimada;
    }

    public byte getEstatus() {
        return estatus;
    }

    public void setEstatus(byte estatus) {
        this.estatus = estatus;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
}