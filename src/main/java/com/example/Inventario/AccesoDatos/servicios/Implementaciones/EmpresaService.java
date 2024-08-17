package com.example.Inventario.AccesoDatos.servicios.Implementaciones;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Inventario.AccesoDatos.repositorios.IEmpresaRepository;
import com.example.Inventario.AccesoDatos.servicios.Interfaces.IEmpresaService;
import com.example.Inventario.EntidadesNegocio.Empresa;
@Service
public class EmpresaService implements IEmpresaService{
    @Autowired
    private IEmpresaRepository empresaRepository;

    @Override
    public List<Empresa> obtenerTodos() {
        return empresaRepository.findAll();
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
