package com.example.Inventario.AccesoDatos.servicios.Implementaciones;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Inventario.AccesoDatos.repositorios.IItemRepository;
import com.example.Inventario.AccesoDatos.servicios.Interfaces.IItemService;
import com.example.Inventario.EntidadesNegocio.Item;

@Service
public class ItemService implements IItemService{
    @Autowired
    private IItemRepository itemRepository;

    @Override
    public List<Item> obtenerTodos() {
        return itemRepository.findAll();
    }

    @Override
    public Optional<Item> buscarPorId(Long id) {
        return itemRepository.findById(id);
    }

    @Override
    public Item crearOEditar(Item item) {
        return itemRepository.save(item);
    }

    @Override
    public void eliminarPorId(Long id) {
        itemRepository.deleteById(id);
    }
}
