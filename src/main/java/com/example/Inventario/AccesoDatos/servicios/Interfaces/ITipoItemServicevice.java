package com.example.Inventario.AccesoDatos.servicios.Interfaces;

import java.util.List;
import java.util.Optional;
import com.example.Inventario.EntidadesNegocio.TipoItem;

public interface ITipoItemServicevice {
    List<TipoItem> obtenerTodos();

    Optional<TipoItem> buscarPorId(Long id);

    TipoItem crearOEditar(TipoItem tipoItem);

    void eliminarPorId(Long id);
    
}
