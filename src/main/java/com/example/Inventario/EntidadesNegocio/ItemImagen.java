package com.example.Inventario.EntidadesNegocio;

import jakarta.persistence.*;

@Entity
@Table(name = "ItemImagen")
public class ItemImagen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_Item", referencedColumnName = "id")
    private Item item;

    @Lob
    private byte[] imagen;

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

    public byte[] getImagen() {
        return imagen;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }
}