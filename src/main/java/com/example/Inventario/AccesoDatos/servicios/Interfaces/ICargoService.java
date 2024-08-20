package com.example.Inventario.AccesoDatos.servicios.Interfaces;

import java.util.List;
import java.util.Optional;
import com.example.Inventario.EntidadesNegocio.Cargo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICargoService {
    Page<Cargo> obtenerTodos(Pageable pageable);

    Optional<Cargo> buscarPorId(Long id);

    Cargo crearOEditar(Cargo cargo);

    void eliminarPorId(Long id);
}
