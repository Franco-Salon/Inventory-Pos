package com.example.Inventario.AccesoDatos.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Inventario.EntidadesNegocio.CompraDetalle;

public interface ICompraDetalleRepository extends JpaRepository<CompraDetalle, Long> {
}
