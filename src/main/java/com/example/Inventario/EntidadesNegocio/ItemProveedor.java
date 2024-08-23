package com.example.Inventario.EntidadesNegocio;

import jakarta.persistence.*;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;


@Entity
@Table(name = "itemProveedor")
public class ItemProveedor
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @ManyToOne
    @JoinColumn(name = "id_Item", nullable = false)
    private Item item;


    @ManyToOne
    @JoinColumn(name = "id_Proveedor", nullable = false)
    private proveedor Proveedor;



    // Getters y Setters
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
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