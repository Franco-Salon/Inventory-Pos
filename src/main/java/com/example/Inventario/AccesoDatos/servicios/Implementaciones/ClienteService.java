package com.example.Inventario.AccesoDatos.servicios.Implementaciones;

import com.example.Inventario.EntidadesNegocio.Cliente;
import com.example.Inventario.AccesoDatos.repositorios.IClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
        @Autowired
        private IClienteRepository clienteRepository;


    public List<Cliente> getAllClientes() {
        return clienteRepository.findAll();
    }



    public Optional<Cliente> getClienteById(Long id) {
        return clienteRepository.findById(id);
    }


    public Cliente saveCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }



    public Cliente updateCliente(Long id, Cliente clienteDetails) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        if (cliente.isPresent()) {
            Cliente updatedCliente = cliente.get();
            updatedCliente.setNombre(clienteDetails.getNombre());
            updatedCliente.setCorreo(clienteDetails.getCorreo());
            // Actualiza otros campos
            return clienteRepository.save(updatedCliente);
        } else {
            throw new RuntimeException("Cliente no encontrado");
        }
    }


    public void deleteCliente(Long id) {
        clienteRepository.deleteById(id);
    }
}
