package com.example.Inventario.AccesoDatos.servicios.Implementaciones;

import com.example.Inventario.AccesoDatos.repositorios.IDepartamentoRepository;
import com.example.Inventario.AccesoDatos.servicios.Interfaces.IDepartamentoService;
import com.example.Inventario.EntidadesNegocio.Departamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartamentoService implements IDepartamentoService {
    @Autowired
    private IDepartamentoRepository departamentoRepository;

    @Override
    public List<Departamento> obtenerTodos() {
        return departamentoRepository.findAll();
    }

    @Override
    public Optional<Departamento> buscarPorId(Long id) {
        return departamentoRepository.findById(id);
    }

    @Override
    public Departamento crearOEditar(Departamento departamento) {
        return departamentoRepository.save(departamento);
    }

    @Override
    public void eliminarPorId(Long id) {
        departamentoRepository.deleteById(id);
    }
}
