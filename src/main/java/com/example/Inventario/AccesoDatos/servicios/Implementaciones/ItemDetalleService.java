package com.example.Inventario.AccesoDatos.servicios.Implementaciones;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Inventario.AccesoDatos.repositorios.IItemDetalleRepository;
import com.example.Inventario.AccesoDatos.servicios.Interfaces.IItemDetalleService;
import com.example.Inventario.EntidadesNegocio.ItemDetalle;

@Service
public class ItemDetalleService implements IItemDetalleService{

    @Autowired
    private IItemDetalleRepository itemDetalleRepository;

    @Override
    public List<ItemDetalle> obtenerTodos() {
        return itemDetalleRepository.findAll();
    }

    @Override
    public Optional<ItemDetalle> buscarPorId(Long id) {
        return itemDetalleRepository.findById(id);
    }

    @Override
    public ItemDetalle crearOEditar(ItemDetalle itemDetalle) {
        return itemDetalleRepository.save(itemDetalle);
    }

    @Override
    public void eliminarPorId(Long id) {
        itemDetalleRepository.deleteById(id);
    }
}
