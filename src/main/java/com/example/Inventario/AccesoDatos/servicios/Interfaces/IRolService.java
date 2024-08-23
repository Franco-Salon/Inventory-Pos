package com.example.Inventario.AccesoDatos.servicios.Interfaces;

import java.util.List;
import java.util.Optional;
import com.example.Inventario.EntidadesNegocio.Rol;

public interface IRolService {
    List<Rol> obtenerTodos();

    Optional<Rol> buscarPorId(Long id);

    Rol crearOEditar(Rol rol);

    void eliminarPorId(Long id);

    List<Rol> listarTodosLosRoles();
}
