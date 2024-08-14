package com.example.Inventario.EntidadesNegocio;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "ItemDetalle")
public class ItemDetalle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_ItemPrincipal")
    private Item itemprincipal;

    @ManyToOne
    @JoinColumn(name = "id_ItemSecundario")
    private Item itemsecundario;

    @NotBlank(message = "El campo es requerido")
    private int cantidad;

    @ManyToOne
    @JoinColumn(name = "id_UnidadMedida")
    private UnidadMedida unidadmedida;


    // Getters y Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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