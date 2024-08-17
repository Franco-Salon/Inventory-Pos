package com.example.Inventario.AccesoDatos.servicios.Interfaces;

import java.util.List;
import java.util.Optional;
import com.example.Inventario.EntidadesNegocio.UnidadMedida;

public interface IUnidadMedidaService {
    List<UnidadMedida> obtenerTodos();

    Optional<UnidadMedida> buscarPorId(Long id);

    UnidadMedida crearOEditar(UnidadMedida unidadMedida);

    void eliminarPorId(Long id);
}
