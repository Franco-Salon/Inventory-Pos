package com.example.Inventario.AccesoDatos.servicios.Implementaciones;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.example.Inventario.AccesoDatos.repositorios.IProveedorRepository;
import com.example.Inventario.AccesoDatos.servicios.Interfaces.IProveedorService;
import com.example.Inventario.EntidadesNegocio.Municipio;
import com.example.Inventario.EntidadesNegocio.proveedor;

@Service
public class ProveedorService implements IProveedorService{
    @Autowired
    private IProveedorRepository proveedorRepository;

    @Override
    public List<proveedor> listarTodos() {
        return proveedorRepository.findAll();
    }

    @Override
    public Page<proveedor> obtenerTodos(Pageable pageable) {
        return proveedorRepository.findAll(pageable);
    }


    @Override
    public Optional<proveedor> buscarPorId(Long id) {
        return proveedorRepository.findById(id);
    }

    @Override
    public proveedor crearOEditar(proveedor proveedor) {
        return proveedorRepository.save(proveedor);
    }

    @Override
    public void eliminarPorId(Long id) {
        proveedorRepository.deleteById(id);
    }
}
