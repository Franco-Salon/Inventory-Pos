package com.example.Inventario.AccesoDatos.servicios.Interfaces;

import java.util.List;
import java.util.Optional;

import com.example.Inventario.EntidadesNegocio.DetalleVenta;

public interface IDetalleVentaService {
    List<DetalleVenta> obtenerTodos();

    Optional<DetalleVenta> buscarPorId(Long id);

    DetalleVenta crearOEditar(DetalleVenta detalleVenta);

    void eliminarPorId(Long id);
}
