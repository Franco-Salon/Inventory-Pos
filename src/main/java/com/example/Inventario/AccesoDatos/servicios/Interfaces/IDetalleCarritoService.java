package com.example.Inventario.AccesoDatos.servicios.Interfaces;

import java.util.List;
import java.util.Optional;
import com.example.Inventario.EntidadesNegocio.DetalleCarrito;

public interface IDetalleCarritoService {
    List<DetalleCarrito> obtenerTodos();

    Optional<DetalleCarrito> buscarPorId(Long id);

    DetalleCarrito crearOEditar(DetalleCarrito detalleCarrito);

    void eliminarPorId(Long id);
}
