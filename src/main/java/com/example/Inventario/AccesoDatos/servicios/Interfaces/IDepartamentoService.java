package com.example.Inventario.AccesoDatos.servicios.Interfaces;

import java.util.List;
import java.util.Optional;
import com.example.Inventario.EntidadesNegocio.Departamento;

public interface IDepartamentoService {
    List<Departamento> obtenerTodos();

    Optional<Departamento> buscarPorId(Long id);

    Departamento crearOEditar(Departamento departamento);

    void eliminarPorId(Long id);
}
