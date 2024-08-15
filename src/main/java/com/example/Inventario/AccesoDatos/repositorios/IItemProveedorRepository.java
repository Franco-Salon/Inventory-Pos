package com.example.Inventario.AccesoDatos.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Inventario.EntidadesNegocio.ItemProveedor;

public interface IItemProveedorRepository extends JpaRepository<ItemProveedor, Long>{
}
