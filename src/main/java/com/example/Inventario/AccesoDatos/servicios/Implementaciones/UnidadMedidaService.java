package com.example.Inventario.AccesoDatos.servicios.Implementaciones;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.example.Inventario.AccesoDatos.repositorios.IUnidadMedidaRepository;
import com.example.Inventario.AccesoDatos.servicios.Interfaces.IUnidadMedidaService;
import com.example.Inventario.EntidadesNegocio.UnidadMedida;

@Service
public class UnidadMedidaService implements IUnidadMedidaService{
    @Autowired
    private IUnidadMedidaRepository unidadMedidaRepository;

    @Override
    public Page<UnidadMedida> obtenerTodos(Pageable pageable) {
        return unidadMedidaRepository.findAll(pageable);
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

     @Override
    public List<UnidadMedida> listarTodasLasUnidadesDeMedidas() {
        return unidadMedidaRepository.findAll();
    }
}
