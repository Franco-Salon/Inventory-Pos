package com.example.Inventario.AccesoDatos.repositorios;

import com.example.Inventario.EntidadesNegocio.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICargoRepository extends JpaRepository<Cargo, Long> {

}
