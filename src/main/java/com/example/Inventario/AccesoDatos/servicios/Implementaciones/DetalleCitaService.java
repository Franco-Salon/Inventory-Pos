package com.example.Inventario.AccesoDatos.servicios.Implementaciones;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Inventario.AccesoDatos.repositorios.IDetalleCitaRepository;
import com.example.Inventario.AccesoDatos.servicios.Interfaces.IDetalleCitaService;
import com.example.Inventario.EntidadesNegocio.DetalleCita;


@Service
public class DetalleCitaService implements IDetalleCitaService{
    @Autowired
    private IDetalleCitaRepository detalleCitaRepository;

    @Override
    public List<DetalleCita> obtenerTodos() {
        return detalleCitaRepository.findAll();
    }

    @Override
    public Optional<DetalleCita> buscarPorId(Long id) {
        return detalleCitaRepository.findById(id);
    }

    @Override
    public DetalleCita crearOEditar(DetalleCita detalleCita) {
        return detalleCitaRepository.save(detalleCita);
    }

    @Override
    public void eliminarPorId(Long id) {
        detalleCitaRepository.deleteById(id);
    }
    
}