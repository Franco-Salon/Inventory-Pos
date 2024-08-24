package com.example.Inventario.AccesoDatos.servicios.Interfaces;

import java.util.Optional;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.Inventario.EntidadesNegocio.proveedor;

public interface IProveedorService {

     List<proveedor> listarTodos();

    Page<proveedor> obtenerTodos(Pageable pageable);

    Optional<proveedor> buscarPorId(Long id);

    proveedor crearOEditar(proveedor proveedor);

    void eliminarPorId(Long id);
}
