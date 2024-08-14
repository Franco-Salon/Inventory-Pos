package com.example.Inventario.EntidadesNegocio;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class CarritoCompra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "el campo es requerida")
    private String codigo;

    @ManyToOne
    @JoinColumn(name = "id_Cliente")
    private Cliente cliente;


    private BigDecimal subTotal;

    private BigDecimal totalPago;

    private BigDecimal totallva;

    @NotBlank(message = "el campo es requerida")
    private String formaPago;

    @NotBlank(message = "el campo es requerida")

    private LocalDate fecha;
    @NotBlank(message = "el campo es requerida")
    private Byte estatus;

    @ManyToOne
    @JoinColumn(name = "id_Empresa")
    private Empresa empresa;
}
