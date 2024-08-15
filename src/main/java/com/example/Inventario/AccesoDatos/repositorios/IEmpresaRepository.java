package com.example.Inventario.AccesoDatos.repositorios;

import com.example.Inventario.EntidadesNegocio.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmpresaRepository extends JpaRepository <Empresa, Long>{
}
