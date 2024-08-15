package com.example.Inventario.EntidadesNegocio;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "itemDetalle")
public class ItemDetalle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "id_ItemPrincipal", referencedColumnName = "id")
    private Item itemprincipal;

    @ManyToOne
    @JoinColumn(name = "id_ItemSecundario", referencedColumnName = "id")
    private Item itemsecundario;

    @NotBlank(message = "El campo es requerido")
    private int cantidad;

    @ManyToOne
    @JoinColumn(name = "id_UnidadMedida", referencedColumnName = "id")
    private UnidadMedida unidadmedida;


    // Getters y Setters

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Item getItemprincipal() {
        return itemprincipal;
    }

    public void setItemprincipal(Item itemprincipal) {
        this.itemprincipal = itemprincipal;
    }

    public Item getItemsecundario() {
        return itemsecundario;
    }

    public void setItemsecundario(Item itemsecundario) {
        this.itemsecundario = itemsecundario;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public UnidadMedida getUnidadmedida() {
        return unidadmedida;
    }

    public void setUnidadmedida(UnidadMedida unidadmedida) {
        this.unidadmedida = unidadmedida;
    }
}