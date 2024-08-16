package com.example.Inventario.AccesoDatos.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Inventario.EntidadesNegocio.CompraDetalle;
import org.springframework.stereotype.Repository;

@Repository
public interface ICompraDetalleRepository extends JpaRepository<CompraDetalle, Long> {
}
