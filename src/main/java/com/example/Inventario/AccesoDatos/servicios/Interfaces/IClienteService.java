package com.example.Inventario.AccesoDatos.servicios.Interfaces;

import java.util.List;
import java.util.Optional;
import com.example.Inventario.EntidadesNegocio.Cliente;

public interface IClienteService {
    List<Cliente> obtenerTodos();

    Optional<Cliente> buscarPorId(Long id);

    Cliente crearOEditar(Cliente cliente);

    void eliminarPorId(Long id);
}
