package com.example.Inventario.AccesoDatos.servicios.Implementaciones;

import com.example.Inventario.AccesoDatos.servicios.Interfaces.ICitaService;
import com.example.Inventario.EntidadesNegocio.Cita;
import com.example.Inventario.AccesoDatos.repositorios.ICitaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CitaService implements ICitaService {

   @Autowired
    private ICitaRepository citaRepository;

    
    @Override
    public List<Cita> listarTodos() {
        return citaRepository.findAll();
    }

    
    @Override
    public Page<Cita> obtenerTodos(Pageable pageable) {
        return citaRepository.findAll(pageable);
    }

    @Override
    public Optional<Cita> buscarPorId(Long id) {
        return citaRepository.findById(id);
    }

    @Override
    public Cita crearOEditar(Cita empresa) {
        return citaRepository.save(empresa);
    }

    @Override
    public void eliminarPorId(Long id) {
        citaRepository.deleteById(id);
    }

}
