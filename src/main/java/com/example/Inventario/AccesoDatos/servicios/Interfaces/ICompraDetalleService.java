package com.example.Inventario.AccesoDatos.servicios.Interfaces;

import com.example.Inventario.EntidadesNegocio.CompraDetalle;
import java.util.List;
import java.util.Optional;

public interface ICompraDetalleService {
    List<CompraDetalle> obtenerTodos();

    Optional<CompraDetalle> buscarPorId(Long id);

    CompraDetalle crearOEditar(CompraDetalle compraDetalle);

    void eliminarPorId(Long id);
}
