package com.example.Inventario.AccesoDatos.servicios.Interfaces;

import java.util.List;
import java.util.Optional;

import com.example.Inventario.EntidadesNegocio.proveedor;

public interface IProveedorService {
    List<proveedor> obtenerTodos();

    Optional<proveedor> buscarPorId(Long id);

    proveedor crearOEditar(proveedor proveedor);

    void eliminarPorId(Long id);
}
