package com.example.Inventario.AccesoDatos.servicios.Implementaciones;

import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
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
    public Page<TipoItem> obtenerTodos(Pageable pageable) {
        return tipoItemRepository.findAll(pageable);
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
