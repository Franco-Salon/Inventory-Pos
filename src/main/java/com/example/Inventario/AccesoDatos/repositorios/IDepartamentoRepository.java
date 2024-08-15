package com.example.Inventario.AccesoDatos.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Inventario.EntidadesNegocio.Departamento;

public interface IDepartamentoRepository extends JpaRepository<Departamento, Long>{
}
