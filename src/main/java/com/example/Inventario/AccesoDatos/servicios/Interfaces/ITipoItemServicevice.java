package com.example.Inventario.AccesoDatos.servicios.Interfaces;

import java.util.List;
import java.util.Optional;
import com.example.Inventario.EntidadesNegocio.TipoItem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ITipoItemServicevice {
    Page<TipoItem> obtenerTodos(Pageable pageable);

    Optional<TipoItem> buscarPorId(Long id);

    TipoItem crearOEditar(TipoItem tipoItem);

    void eliminarPorId(Long id);
    
}
