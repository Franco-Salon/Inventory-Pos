package com.example.Inventario.AccesoDatos.servicios.Interfaces;

import java.util.List;
import java.util.Optional;
import com.example.Inventario.EntidadesNegocio.Departamento;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IDepartamentoService {

     List<Departamento> listarTodos();
     
    Page<Departamento> obtenerTodos(Pageable pageable);

    Optional<Departamento> buscarPorId(Long id);

    Departamento crearOEditar(Departamento departamento);

    void eliminarPorId(Long id);

    List<Departamento> listarTodosLosRoles();
}
