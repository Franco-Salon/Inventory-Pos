package com.example.Inventario.EntidadesNegocio;

import jakarta.persistence.*;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;


@Entity
@Table(name = "ItemProveedor")
public class ItemProveedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_Item")
    private Item item;

    @ManyToOne
    @JoinColumn(name = "id_Proveedor")
    private proveedor Proveedor;

    // Getters y Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public proveedor getProveedor() {
        return Proveedor;
    }

    public void setProveedor(proveedor proveedor) {
        Proveedor = proveedor;
    }
}