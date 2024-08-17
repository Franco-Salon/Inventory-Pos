package com.example.Inventario.AccesoDatos.servicios.Interfaces;

import java.util.List;
import java.util.Optional;
import com.example.Inventario.EntidadesNegocio.Municipio;

public interface IMunicipioService {
     List<Municipio> obtenerTodos();

    Optional<Municipio> buscarPorId(Long id);

    Municipio crearOEditar(Municipio municipio);

    void eliminarPorId(Long id);
}
