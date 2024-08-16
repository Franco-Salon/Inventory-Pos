package com.example.Inventario.AccesoDatos.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Inventario.EntidadesNegocio.ItemImagen;
import org.springframework.stereotype.Repository;

@Repository
public interface IItemImagenRepository extends JpaRepository<ItemImagen, Long> {
}
