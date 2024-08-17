package com.example.Inventario.AccesoDatos.servicios.Implementaciones;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Inventario.AccesoDatos.repositorios.IDetalleVentaRepository;
import com.example.Inventario.AccesoDatos.servicios.Interfaces.IDetalleVentaService;
import com.example.Inventario.EntidadesNegocio.DetalleVenta;

@Service
public class DetalleVentaService implements IDetalleVentaService{
    @Autowired
    private IDetalleVentaRepository detalleVentaRepository;

    @Override
    public List<DetalleVenta> obtenerTodos() {
        return detalleVentaRepository.findAll();
    }

    @Override
    public Optional<DetalleVenta> buscarPorId(Long id) {
        return detalleVentaRepository.findById(id);
    }

    @Override
    public DetalleVenta crearOEditar(DetalleVenta detalleVenta) {
        return detalleVentaRepository.save(detalleVenta);
    }

    @Override
    public void eliminarPorId(Long id) {
        detalleVentaRepository.deleteById(id);
    }
}
