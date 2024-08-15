package com.example.Inventario.AccesoDatos.servicios.Implementaciones;

import com.example.Inventario.AccesoDatos.servicios.Interfaces.ICarritoCompraService;
import com.example.Inventario.EntidadesNegocio.CarritoCompra;
import com.example.Inventario.AccesoDatos.repositorios.ICarritoCompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarritoCompraService implements ICarritoCompraService {

    @Autowired
    private ICarritoCompraRepository carritoCompraRepository;

    @Override
    public List<CarritoCompra> obtenerTodos() {
        return carritoCompraRepository.findAll();
    }

    @Override
    public Optional<CarritoCompra> buscarPorId(Long id) {
        return carritoCompraRepository.findById(id);
    }

    @Override
    public CarritoCompra crearOEditar(CarritoCompra carritoCompra) {
        return carritoCompraRepository.save(carritoCompra);
    }

    @Override
    public void eliminarPorId(Long id) {
        carritoCompraRepository.deleteById(id);
    }
}
