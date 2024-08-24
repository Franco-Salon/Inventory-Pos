package com.example.Inventario.AccesoDatos.servicios.Interfaces;

import java.util.List;
import java.util.Optional;
import com.example.Inventario.EntidadesNegocio.Municipio;
import org.springframework.data.domain.*;

public interface IMunicipioService {

    List<Municipio> listarTodos();

    Page<Municipio> obtenerTodos(Pageable pageable);

    Optional<Municipio> buscarPorId(Long id);

    Municipio crearOEditar(Municipio municipio);

    void eliminarPorId(Long id);
}
