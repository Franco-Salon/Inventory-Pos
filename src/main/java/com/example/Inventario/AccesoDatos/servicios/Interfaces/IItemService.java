package com.example.Inventario.AccesoDatos.servicios.Interfaces;

import java.util.List;
import java.util.Optional;


import com.example.Inventario.EntidadesNegocio.Item;

public interface IItemService {
    List<Item> obtenerTodos();

    Optional<Item> buscarPorId(Long id);

    Item crearOEditar(Item item);

    void eliminarPorId(Long id);
}
