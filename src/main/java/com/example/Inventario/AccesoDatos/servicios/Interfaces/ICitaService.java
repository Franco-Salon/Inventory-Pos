package com.example.Inventario.AccesoDatos.servicios.Interfaces;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.Inventario.EntidadesNegocio.Cita;

public interface ICitaService {
    List<Cita> listarTodos();

    Page<Cita> obtenerTodos(Pageable pageable);

    Optional<Cita> buscarPorId(Long id);

    Cita crearOEditar(Cita cita);

    void eliminarPorId(Long id);
}
