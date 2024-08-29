package com.example.Inventario.AccesoDatos.servicios.Implementaciones;

import com.example.Inventario.AccesoDatos.servicios.Interfaces.ICategoriaItemService;
import com.example.Inventario.EntidadesNegocio.CategoriaItem;
import com.example.Inventario.AccesoDatos.repositorios.ICategoriaItemRepository;

import org.springframework.data.domain.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaItemService implements ICategoriaItemService {

    @Autowired
    private ICategoriaItemRepository categoriaItemRepository;

    @Override
    public Page<CategoriaItem> buscarTodosPaginados(Pageable pageable) {
        return categoriaItemRepository.findAll(pageable);
    }

    @Override
    public List<CategoriaItem> obtenerTodos() {
        return categoriaItemRepository.findAll();
    }

    @Override
    public Optional<CategoriaItem> buscarPorId(Long id) {
        return categoriaItemRepository.findById(id);
    }

    @Override
    public CategoriaItem crearOEditar(CategoriaItem categoriaItem) {
        return categoriaItemRepository.save(categoriaItem);
    }

    @Override
    public void eliminarPorId(Long id) {
        categoriaItemRepository.deleteById(id);
    }

}
