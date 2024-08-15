package com.example.Inventario.EntidadesNegocio;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Table(name = "Ajuste")
public class Ajuste {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "La fecha de vencimiento es requerida")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fecha;

    @ManyToOne
    @JoinColumn(name = "id_Item", referencedColumnName = "id")
    private Item item;

    @ManyToOne
    @JoinColumn(name = "id_Usuario", referencedColumnName = "id")
    private Usuario usuario;


    private Integer cantidad;

    @ManyToOne
    @JoinColumn(name = "id_UnidadMedida", referencedColumnName = "id")
    private UnidadMedida unidadwedida;

    @Column(name = "tipo_movimiento")
    private Byte tipoMovimiento;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public UnidadMedida getUnidadwedida() {
        return unidadwedida;
    }

    public void setUnidadwedida(UnidadMedida unidadwedida) {
        this.unidadwedida = unidadwedida;
    }

    public Byte getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(Byte tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }
}