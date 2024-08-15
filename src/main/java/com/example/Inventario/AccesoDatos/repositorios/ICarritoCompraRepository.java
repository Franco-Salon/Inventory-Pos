package com.example.Inventario.AccesoDatos.repositorios;

import com.example.Inventario.EntidadesNegocio.CarritoCompra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICarritoCompraRepository extends JpaRepository<CarritoCompra, Long> {


}
