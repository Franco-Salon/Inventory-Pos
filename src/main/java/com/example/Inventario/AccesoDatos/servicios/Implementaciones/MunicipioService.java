package com.example.Inventario.AccesoDatos.servicios.Implementaciones;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import com.example.Inventario.AccesoDatos.repositorios.IMunicipioRepository;
import com.example.Inventario.AccesoDatos.servicios.Interfaces.IMunicipioService;
import com.example.Inventario.EntidadesNegocio.Municipio;

@Service
public class MunicipioService implements IMunicipioService{
    @Autowired
    private IMunicipioRepository municipioRepository;

    @Override
    public Page<Municipio> obtenerTodos(Pageable pageable) {
        return municipioRepository.findAll(pageable);
    }

    @Override
    public Optional<Municipio> buscarPorId(Long id) {
        return municipioRepository.findById(id);
    }

    @Override
    public Municipio crearOEditar(Municipio municipio) {
        return municipioRepository.save(municipio);
    }

    @Override
    public void eliminarPorId(Long id) {
        municipioRepository.deleteById(id);
    }
}
