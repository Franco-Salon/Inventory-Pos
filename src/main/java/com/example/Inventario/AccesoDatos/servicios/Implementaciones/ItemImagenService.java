package com.example.Inventario.AccesoDatos.servicios.Implementaciones;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Inventario.AccesoDatos.repositorios.IItemImagenRepository;
import com.example.Inventario.AccesoDatos.servicios.Interfaces.IItemImagenService;
import com.example.Inventario.EntidadesNegocio.ItemImagen;
@Service
public class ItemImagenService  implements IItemImagenService{
     @Autowired
    private IItemImagenRepository itemImagenRepository;

    @Override
    public List<ItemImagen> obtenerTodos() {
        return itemImagenRepository.findAll();
    }

    @Override
    public Optional<ItemImagen> buscarPorId(Long id) {
        return itemImagenRepository.findById(id);
    }

    @Override
    public ItemImagen crearOEditar(ItemImagen itemImagen) {
        return itemImagenRepository.save(itemImagen);
    }

    @Override
    public void eliminarPorId(Long id) {
        itemImagenRepository.deleteById(id);
    }
}
