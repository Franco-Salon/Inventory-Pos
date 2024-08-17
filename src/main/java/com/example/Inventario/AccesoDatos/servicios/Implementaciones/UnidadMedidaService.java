package com.example.Inventario.AccesoDatos.servicios.Implementaciones;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Inventario.AccesoDatos.repositorios.IUnidadMedidaRepository;
import com.example.Inventario.AccesoDatos.servicios.Interfaces.IUnidadMedidaService;
import com.example.Inventario.EntidadesNegocio.UnidadMedida;

@Service
public class UnidadMedidaService implements IUnidadMedidaService{
    @Autowired
    private IUnidadMedidaRepository unidadMedidaRepository;

    @Override
    public List<UnidadMedida> obtenerTodos() {
        return unidadMedidaRepository.findAll();
    }

    @Override
    public Optional<UnidadMedida> buscarPorId(Long id) {
        return unidadMedidaRepository.findById(id);
    }

    @Override
    public UnidadMedida crearOEditar(UnidadMedida unidadMedida) {
        return unidadMedidaRepository.save(unidadMedida);
    }

    @Override
    public void eliminarPorId(Long id) {
        unidadMedidaRepository.deleteById(id);
    }
}
