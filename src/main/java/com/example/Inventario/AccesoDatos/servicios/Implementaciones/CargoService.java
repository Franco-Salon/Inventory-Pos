package com.example.Inventario.AccesoDatos.servicios.Implementaciones;

import com.example.Inventario.AccesoDatos.servicios.Interfaces.ICargoService;
import com.example.Inventario.EntidadesNegocio.Cargo;
import com.example.Inventario.AccesoDatos.repositorios.ICargoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CargoService implements ICargoService {

    @Autowired
    private ICargoRepository cargoRepository;

    @Override
    public List<Cargo> obtenerTodos() {
        return cargoRepository.findAll();
    }

    @Override
    public Optional<Cargo> buscarPorId(Long id) {
        return cargoRepository.findById(id);
    }

    @Override
    public Cargo crearOEditar(Cargo cargo) {
        return cargoRepository.save(cargo);
    }

    @Override
    public void eliminarPorId(Long id) {
        cargoRepository.deleteById(id);
    }
}
