package com.example.Inventario.AccesoDatos.servicios.Implementaciones;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Inventario.AccesoDatos.repositorios.IRolRepository;
import com.example.Inventario.AccesoDatos.servicios.Interfaces.IRolService;
import com.example.Inventario.EntidadesNegocio.Rol;
@Service
public class RolService implements IRolService{
    @Autowired
    private IRolRepository rolRepository;

    @Override
    public List<Rol> obtenerTodos() {
        return rolRepository.findAll();
    }

    @Override
    public Optional<Rol> buscarPorId(Long id) {
        return rolRepository.findById(id);
    }

    @Override
    public Rol crearOEditar(Rol rol) {
        return rolRepository.save(rol);
    }

    @Override
    public void eliminarPorId(Long id) {
        rolRepository.deleteById(id);
    }
    @Override
    public List<Rol> listarTodosLosRoles() {
        return rolRepository.findAll();
    }
}
