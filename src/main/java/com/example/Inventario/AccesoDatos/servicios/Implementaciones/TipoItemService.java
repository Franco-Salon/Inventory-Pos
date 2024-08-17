package com.example.Inventario.AccesoDatos.servicios.Implementaciones;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Inventario.AccesoDatos.repositorios.ITipoItemRepository;
import com.example.Inventario.AccesoDatos.servicios.Interfaces.ITipoItemServicevice;
import com.example.Inventario.EntidadesNegocio.TipoItem;

@Service
public class TipoItemService implements ITipoItemServicevice {
    @Autowired
    private ITipoItemRepository tipoItemRepository;

    @Override
    public List<TipoItem> obtenerTodos() {
        return tipoItemRepository.findAll();
    }

    @Override
    public Optional<TipoItem> buscarPorId(Long id) {
        return tipoItemRepository.findById(id);
    }

    @Override
    public TipoItem crearOEditar(TipoItem tipoItem) {
        return tipoItemRepository.save(tipoItem);
    }

    @Override
    public void eliminarPorId(Long id) {
        tipoItemRepository.deleteById(id);
    }
}
