package com.example.Inventario.AccesoDatos.servicios.Interfaces;

import java.util.List;
import java.util.Optional;
import com.example.Inventario.EntidadesNegocio.Cita;

public interface ICitaService {
    List<Cita> obtenerTodos();

    Optional<Cita> buscarPorId(Long id);

    Cita crearOEditar(Cita cita);

    void eliminarPorId(Long id);
}
