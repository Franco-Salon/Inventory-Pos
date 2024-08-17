package com.example.Inventario.AccesoDatos.servicios.Implementaciones;

import com.example.Inventario.AccesoDatos.servicios.Interfaces.IClienteService;
import com.example.Inventario.EntidadesNegocio.Cliente;
import com.example.Inventario.AccesoDatos.repositorios.IClienteRepository;
import com.example.Inventario.EntidadesNegocio.CompraDetalle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService implements IClienteService {
        @Autowired
        private IClienteRepository clienteRepository;


    @Override
    public List<Cliente> obtenerTodos() {
        return clienteRepository.findAll();
    }

    @Override
    public Optional<Cliente> buscarPorId(Long id) {
        return clienteRepository.findById(id);
    }

    @Override
    public Cliente crearOEditar(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public void eliminarPorId(Long id) {
        clienteRepository.deleteById(id);
    }
}
