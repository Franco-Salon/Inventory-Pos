package com.example.Inventario.AccesoDatos.servicios.Interfaces;

import java.util.List;
import java.util.Optional;

import com.example.Inventario.EntidadesNegocio.DetalleCita;

public interface IDetalleCitaService {

    List<DetalleCita> obtenerTodos();

    Optional<DetalleCita> buscarPorId(Long id);

    DetalleCita crearOEditar(DetalleCita detalleCita);

    void eliminarPorId(Long id);
}
