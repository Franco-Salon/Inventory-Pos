package com.example.Inventario.AccesoDatos.repositorios;

import com.example.Inventario.EntidadesNegocio.Ajuste;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAjusteRepository extends JpaRepository<Ajuste, Long>{
}
