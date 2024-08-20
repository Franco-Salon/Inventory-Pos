package com.example.Inventario.AccesoDatos.servicios.Interfaces;

import java.util.List;
import java.util.Optional;

import com.example.Inventario.EntidadesNegocio.Empresa;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IEmpresaService {
    Page<Empresa> obtenerTodos(Pageable pageable);

    Optional<Empresa> buscarPorId(Long id);

    Empresa crearOEditar(Empresa empresa);

    void eliminarPorId(Long id);
}
