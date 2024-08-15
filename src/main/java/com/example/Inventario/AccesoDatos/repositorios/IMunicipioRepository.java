package com.example.Inventario.AccesoDatos.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Inventario.EntidadesNegocio.Municipio;
import org.springframework.stereotype.Repository;


@Repository
public interface IMunicipioRepository extends JpaRepository<Municipio, Long>{
}
