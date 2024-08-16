package com.example.Inventario.AccesoDatos.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Inventario.EntidadesNegocio.ItemProveedor;
import org.springframework.stereotype.Repository;

@Repository
public interface IItemProveedorRepository extends JpaRepository<ItemProveedor, Long>{
}
