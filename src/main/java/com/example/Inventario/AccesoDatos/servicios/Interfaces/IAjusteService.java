package com.example.Inventario.AccesoDatos.servicios.Interfaces;

import java.util.List;
import java.util.Optional;
import com.example.Inventario.EntidadesNegocio.Ajuste;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IAjusteService {

    Page<Ajuste> buscarTodosPaginados(Pageable pageable);

    List<Ajuste> obtenerTodos();

    Optional<Ajuste> buscarPorId(Long id);

    Ajuste crearOEditar(Ajuste ajuste);

    void eliminarPorId(Long id);
       
    List<Ajuste> listarTodosLosAjustes();


}
