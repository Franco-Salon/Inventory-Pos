package com.example.Inventario.AccesoDatos.servicios.Interfaces;

import java.util.List;
import java.util.Optional;
import com.example.Inventario.EntidadesNegocio.UnidadMedida;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IUnidadMedidaService {
    Page<UnidadMedida> obtenerTodos(Pageable pageable);

    Optional<UnidadMedida> buscarPorId(Long id);

    UnidadMedida crearOEditar(UnidadMedida unidadMedida);

    void eliminarPorId(Long id);
}
