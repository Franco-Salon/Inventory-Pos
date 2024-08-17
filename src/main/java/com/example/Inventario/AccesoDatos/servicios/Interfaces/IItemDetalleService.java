package com.example.Inventario.AccesoDatos.servicios.Interfaces;

import java.util.List;
import java.util.Optional;


import com.example.Inventario.EntidadesNegocio.ItemDetalle;

public interface IItemDetalleService {
    
    List<ItemDetalle> obtenerTodos();

    Optional<ItemDetalle> buscarPorId(Long id);

    ItemDetalle crearOEditar(ItemDetalle itemDetalle);

    void eliminarPorId(Long id);
}
