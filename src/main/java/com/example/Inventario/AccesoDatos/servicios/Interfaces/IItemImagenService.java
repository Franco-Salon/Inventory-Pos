package com.example.Inventario.AccesoDatos.servicios.Interfaces;

import java.util.List;
import java.util.Optional;
import com.example.Inventario.EntidadesNegocio.ItemImagen;

public interface IItemImagenService {
    List<ItemImagen> obtenerTodos();

    Optional<ItemImagen> buscarPorId(Long id);

    ItemImagen crearOEditar(ItemImagen itemImagen);

    void eliminarPorId(Long id);
}
