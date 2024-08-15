package com.example.Inventario.AccesoDatos.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Inventario.EntidadesNegocio.Compra;

public interface ICompraRepository extends JpaRepository<Compra, Long>{
}
