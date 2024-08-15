package com.example.Inventario.AccesoDatos.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Inventario.EntidadesNegocio.UnidadMedida;

public interface IUnidadMedidaRepository extends JpaRepository<UnidadMedida, Long>{
    
}
