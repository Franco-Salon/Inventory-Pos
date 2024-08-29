package com.example.Inventario.AccesoDatos.servicios.Interfaces;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.Inventario.EntidadesNegocio.CategoriaItem;

public interface ICategoriaItemService {

    Page<CategoriaItem> buscarTodosPaginados(Pageable pageable);

    List<CategoriaItem> obtenerTodos();

    Optional<CategoriaItem> buscarPorId(Long id);

    CategoriaItem crearOEditar(CategoriaItem categoriaItem);

    void eliminarPorId(Long id);
}
