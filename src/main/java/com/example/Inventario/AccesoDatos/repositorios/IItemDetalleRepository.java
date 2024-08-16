package com.example.Inventario.AccesoDatos.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Inventario.EntidadesNegocio.ItemDetalle;
import org.springframework.stereotype.Repository;

@Repository
public  interface IItemDetalleRepository extends JpaRepository<ItemDetalle, Long>{
}