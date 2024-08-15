package com.example.Inventario.AccesoDatos.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Inventario.EntidadesNegocio.DetalleCarrito;

public interface IDetalleCarritoRepository extends JpaRepository<DetalleCarrito, Long>{
}
