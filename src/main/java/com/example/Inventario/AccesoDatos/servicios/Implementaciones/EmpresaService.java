package com.example.Inventario.AccesoDatos.servicios.Implementaciones;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.Inventario.AccesoDatos.repositorios.IEmpresaRepository;
import com.example.Inventario.AccesoDatos.servicios.Interfaces.IEmpresaService;
import com.example.Inventario.EntidadesNegocio.Empresa;
import com.example.Inventario.EntidadesNegocio.proveedor;
@Service
public class EmpresaService implements IEmpresaService{
    @Autowired
    private IEmpresaRepository empresaRepository;

    
    @Override
    public List<Empresa> listarTodos() {
        return empresaRepository.findAll();
    }

    
    @Override
    public Page<Empresa> obtenerTodos(Pageable pageable) {
        return empresaRepository.findAll(pageable);
    }

    @Override
    public Optional<Empresa> buscarPorId(Long id) {
        return empresaRepository.findById(id);
    }

    @Override
    public Empresa crearOEditar(Empresa empresa) {
        return empresaRepository.save(empresa);
    }

    @Override
    public void eliminarPorId(Long id) {
        empresaRepository.deleteById(id);
    }
}
