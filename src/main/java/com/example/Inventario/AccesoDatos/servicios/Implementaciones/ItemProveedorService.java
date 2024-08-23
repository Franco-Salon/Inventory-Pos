package com.example.Inventario.AccesoDatos.servicios.Implementaciones;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Inventario.AccesoDatos.repositorios.IItemProveedorRepository;
import com.example.Inventario.AccesoDatos.servicios.Interfaces.IItemProveedorService;
import com.example.Inventario.EntidadesNegocio.ItemProveedor;

@Service
public class ItemProveedorService implements IItemProveedorService{
    @Autowired
    private IItemProveedorRepository itemProveedorRepository;

    @Override
    public List<ItemProveedor> obtenerTodos() {
        return itemProveedorRepository.findAll();
    }

    @Override
    public Optional<ItemProveedor> buscarPorId(Integer id) {
        return itemProveedorRepository.findById(id);
    }

    @Override
    public ItemProveedor crearOEditar(ItemProveedor itemProveedor) {
        return itemProveedorRepository.save(itemProveedor);
    }

    @Override
    public void eliminarPorId(Integer id) {
        itemProveedorRepository.deleteById(id);
    }
}
