package com.example.Inventario.AccesoDatos.servicios.Interfaces;

import java.util.List;
import java.util.Optional;
import com.example.Inventario.EntidadesNegocio.CarritoCompra;

public interface ICarritoCompraService {
    List<CarritoCompra> obtenerTodos();

    Optional<CarritoCompra> buscarPorId(Long id);

    CarritoCompra crearOEditar(CarritoCompra carritoCompra);

    void eliminarPorId(Long id);
}
