package com.example.Inventario.AccesoDatos.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Inventario.EntidadesNegocio.DetalleVenta;

public interface IDetalleVentaRepository extends JpaRepository<DetalleVenta, Long>{
}
