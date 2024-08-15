package com.example.Inventario.AccesoDatos.servicios.Implementaciones;

import com.example.Inventario.AccesoDatos.servicios.Interfaces.IAjusteService;
import com.example.Inventario.EntidadesNegocio.Ajuste;
import com.example.Inventario.AccesoDatos.repositorios.IAjusteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AjusteService implements IAjusteService {

    @Autowired
    private IAjusteRepository ajusteRepository;

    @Override
    public List<Ajuste> obtenerTodos() {
        return ajusteRepository.findAll();
    }

    @Override
    public Optional<Ajuste> buscarPorId(Long id) {
        return ajusteRepository.findById(id);
    }

    @Override
    public Ajuste crearOEditar(Ajuste ajuste) {
        return ajusteRepository.save(ajuste);
    }

    @Override
    public void eliminarPorId(Long id) {
        ajusteRepository.deleteById(id);
    }

}
