package com.example.Inventario.AccesoDatos.repositorios;

import com.example.Inventario.EntidadesNegocio.Cita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICitaRepository extends JpaRepository<Cita, Long> {
}
