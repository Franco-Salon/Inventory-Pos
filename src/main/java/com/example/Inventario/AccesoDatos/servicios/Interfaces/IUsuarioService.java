package com.example.Inventario.AccesoDatos.servicios.Interfaces;

import java.util.List;
import java.util.Optional;
import com.example.Inventario.EntidadesNegocio.Usuario;

public interface IUsuarioService {

    List<Usuario> obtenerTodos();

    Optional<Usuario> buscarPorId(Long id);

    Usuario crearOEditar(Usuario usuario);

    void eliminarPorId(Long id);
}
