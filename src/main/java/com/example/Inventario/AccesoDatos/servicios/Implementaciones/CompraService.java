package com.example.Inventario.AccesoDatos.servicios.Implementaciones;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Inventario.EntidadesNegocio.Compra;
import com.example.Inventario.AccesoDatos.repositorios.ICompraRepository;
import com.example.Inventario.AccesoDatos.servicios.Interfaces.ICompraService;

import java.util.List;
import java.util.Optional;

@Service
public class CompraService implements ICompraService{

    @Autowired
    private ICompraRepository compraRepository;

    @Override
    public List<Compra> obtenerTodos() {
        return compraRepository.findAll();
    }

    @Override
    public Optional<Compra> buscarPorId(Long id) {
        return compraRepository.findById(id);
    }

    @Override
    public Compra crearOEditar(Compra compra) {
        return compraRepository.save(compra);
    }

    @Override
    public void eliminarPorId(Long id) {
        compraRepository.deleteById(id);
    }
}
