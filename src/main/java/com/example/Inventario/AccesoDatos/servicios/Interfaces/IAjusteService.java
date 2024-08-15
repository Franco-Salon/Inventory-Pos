package com.example.Inventario.AccesoDatos.servicios.Interfaces;

import java.util.List;
import java.util.Optional;
import com.example.Inventario.EntidadesNegocio.Ajuste;

public interface IAjusteService {
    List<Ajuste> obtenerTodos();

    Optional<Ajuste> buscarPorId(Long id);

    Ajuste crearOEditar(Ajuste ajuste);

    void eliminarPorId(Long id);
}
