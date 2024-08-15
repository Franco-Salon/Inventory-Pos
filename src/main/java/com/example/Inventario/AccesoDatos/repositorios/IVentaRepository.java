package com.example.Inventario.AccesoDatos.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Inventario.EntidadesNegocio.Venta;

public interface IVentaRepository extends JpaRepository<Venta, Long> {
    
}
