package com.example.Inventario.AccesoDatos.servicios.Interfaces;

import java.util.List;
import java.util.Optional;

import com.example.Inventario.AccesoDatos.servicios.Implementaciones.ItemService;
import com.example.Inventario.EntidadesNegocio.Item;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IItemService {

    Page<Item> buscarTodosPaginados(Pageable pageable);

    List<Item> obtenerTodos();

    Optional<Item> buscarPorId(Long id);

    Item crearOEditar(Item item);

    void eliminarPorId(Long id);

    List<Item> listaTodosLosItems();

}
