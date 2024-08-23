package com.example.Inventario.AccesoDatos.servicios.Interfaces;

import java.util.List;
import java.util.Optional;
import com.example.Inventario.EntidadesNegocio.ItemProveedor;

public interface IItemProveedorService {
    List<ItemProveedor> obtenerTodos();

    Optional<ItemProveedor> buscarPorId(Integer id);

    ItemProveedor crearOEditar(ItemProveedor itemProveedor);

    void eliminarPorId(Integer id);
}
