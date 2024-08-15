package com.example.Inventario.AccesoDatos.servicios.Interfaces;

import java.util.List;
import java.util.Optional;
import com.example.Inventario.EntidadesNegocio.Cargo;

public interface ICargoService {
    List<Cargo> obtenerTodos();

    Optional<Cargo> buscarPorId(Long id);

    Cargo crearOEditar(Cargo cargo);

    void eliminarPorId(Long id);
}
