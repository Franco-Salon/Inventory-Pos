package com.example.Inventario.EntidadesNegocio;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Ajuste")
public class Ajuste {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private LocalDate fecha;

    @ManyToOne
    @JoinColumn(name = "id_Item")
    private Item item;

    @ManyToOne
    @JoinColumn(name = "id_Usuario")
    private Usuario usuario;

    @Column(name = "cantidad")
    private Integer cantidad;

    @Column(name = "id_unidad_medida")
    private Integer idUnidadMedida;

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

    public Integer getIdUnidadMedida() {
        return idUnidadMedida;
    }

    public void setIdUnidadMedida(Integer idUnidadMedida) {
        this.idUnidadMedida = idUnidadMedida;
    }

    public Byte getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(Byte tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }
}