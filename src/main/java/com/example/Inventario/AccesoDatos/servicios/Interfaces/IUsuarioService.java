package com.example.Inventario.AccesoDatos.servicios.Interfaces;

import java.util.Optional;
import com.example.Inventario.EntidadesNegocio.Usuario;
import org.springframework.data.domain.*;

public interface IUsuarioService {

    Page<Usuario> obtenerTodos(Pageable pageable);

    Optional<Usuario> buscarPorId(Long id);

    Usuario crearOEditar(Usuario usuario);

    void eliminarPorId(Long id);
}
