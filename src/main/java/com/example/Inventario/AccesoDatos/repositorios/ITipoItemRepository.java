package com.example.Inventario.AccesoDatos.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Inventario.EntidadesNegocio.TipoItem;
import org.springframework.stereotype.Repository;

@Repository
public interface ITipoItemRepository extends JpaRepository<TipoItem, Long> {
}
