package com.example.Inventario.AccesoDatos.servicios.Implementaciones;

import com.example.Inventario.AccesoDatos.repositorios.IDetalleCarritoRepository;
import com.example.Inventario.AccesoDatos.servicios.Interfaces.IDetalleCarritoService;
import com.example.Inventario.EntidadesNegocio.DetalleCarrito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DetalleCarritoService implements IDetalleCarritoService {
    @Autowired
    private IDetalleCarritoRepository detalleCarritoRepository;

    @Override
    public List<DetalleCarrito> obtenerTodos() {
        return detalleCarritoRepository.findAll();
    }

    @Override
    public Optional<DetalleCarrito> buscarPorId(Long id) {
        return detalleCarritoRepository.findById(id);
    }

    @Override
    public DetalleCarrito crearOEditar(DetalleCarrito detalleCarrito) {
        return detalleCarritoRepository.save(detalleCarrito);
    }

    @Override
    public void eliminarPorId(Long id) {
        detalleCarritoRepository.deleteById(id);
    }
}
