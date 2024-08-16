package com.example.Inventario.EntidadesNegocio;

import jakarta.persistence.*;

import java.math.BigDecimal;


@Entity
@Table(name = "detalleCarrito")
public class DetalleCarrito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_CarritoCompra", referencedColumnName = "id")
    private CarritoCompra carritocompra;

    @ManyToOne
    @JoinColumn(name = "id_Item", referencedColumnName = "id")
    private Item item;


    private BigDecimal precio;


    private Integer cantidad;

    @ManyToOne
    @JoinColumn(name = "id_UnidadMedida", referencedColumnName = "id")
    private UnidadMedida unidadmedida;

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CarritoCompra getCarritocompra() {
        return carritocompra;
    }

    public void setCarritocompra(CarritoCompra carritocompra) {
        this.carritocompra = carritocompra;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public UnidadMedida getUnidadmedida() {
        return unidadmedida;
    }

    public void setUnidadmedida(UnidadMedida unidadmedida) {
        this.unidadmedida = unidadmedida;
    }
}
