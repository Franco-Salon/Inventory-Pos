package com.example.Inventario.AccesoDatos.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Inventario.EntidadesNegocio.TipoItem;

public interface ITipoItemRepository extends JpaRepository<TipoItem, Long> {
}
