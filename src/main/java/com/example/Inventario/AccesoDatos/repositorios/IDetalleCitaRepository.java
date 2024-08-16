package com.example.Inventario.AccesoDatos.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Inventario.EntidadesNegocio.DetalleCita;
import org.springframework.stereotype.Repository;

@Repository
public interface IDetalleCitaRepository extends JpaRepository<DetalleCita, Long>{
}
