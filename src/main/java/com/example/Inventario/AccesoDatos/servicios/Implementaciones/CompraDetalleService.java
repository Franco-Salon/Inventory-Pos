package com.example.Inventario.AccesoDatos.servicios.Implementaciones;

import com.example.Inventario.AccesoDatos.repositorios.ICompraDetalleRepository;
import com.example.Inventario.AccesoDatos.servicios.Interfaces.ICompraDetalleService;
import com.example.Inventario.EntidadesNegocio.CompraDetalle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompraDetalleService implements ICompraDetalleService {
    @Autowired
    private ICompraDetalleRepository compraDetalleRepository;

    @Override
    public List<CompraDetalle> obtenerTodos() {
        return compraDetalleRepository.findAll();
    }

    @Override
    public Optional<CompraDetalle> buscarPorId(Long id) {
        return compraDetalleRepository.findById(id);
    }

    @Override
    public CompraDetalle crearOEditar(CompraDetalle compraDetalle) {
        return compraDetalleRepository.save(compraDetalle);
    }

    @Override
    public void eliminarPorId(Long id) {
        compraDetalleRepository.deleteById(id);
    }
}
