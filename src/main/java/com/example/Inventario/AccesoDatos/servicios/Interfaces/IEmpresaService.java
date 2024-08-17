package com.example.Inventario.AccesoDatos.servicios.Interfaces;

import java.util.List;
import java.util.Optional;

import com.example.Inventario.EntidadesNegocio.Empresa;

public interface IEmpresaService {
    List<Empresa> obtenerTodos();

    Optional<Empresa> buscarPorId(Long id);

    Empresa crearOEditar(Empresa empresa);

    void eliminarPorId(Long id);
}
