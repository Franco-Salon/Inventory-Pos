package com.example.Inventario.AccesoDatos.servicios.Interfaces;

import java.util.List;
import java.util.Optional;
import com.example.Inventario.EntidadesNegocio.Compra;

public interface ICompraService {
    List<Compra> obtenerTodos();

    Optional<Compra> buscarPorId(Long id);

    Compra crearOEditar(Compra compra);

    void eliminarPorId(Long id);
}
