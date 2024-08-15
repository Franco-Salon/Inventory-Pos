package com.example.Inventario.AccesoDatos.servicios.Interfaces;

import java.util.List;
import java.util.Optional;
import com.example.Inventario.EntidadesNegocio.CategoriaItem;

public interface ICategoriaItemService {
    List<CategoriaItem> obtenerTodos();

    Optional<CategoriaItem> buscarPorId(Long id);

    CategoriaItem crearOEditar(CategoriaItem categoriaItem);

    void eliminarPorId(Long id);
}
