package com.example.Inventario.EntidadesNegocio;


import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "compraDetalle")
public class CompraDetalle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "id_Compra", referencedColumnName = "id")
    private Compra compra;

    @ManyToOne
    @JoinColumn(name = "id_Item", referencedColumnName = "id")
    private Item item;

    private int cantidad;

    private BigDecimal precio;

    // Getters and Setters
    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }
}
