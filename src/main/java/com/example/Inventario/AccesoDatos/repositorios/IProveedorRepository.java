package com.example.Inventario.AccesoDatos.repositorios;
import com.example.Inventario.EntidadesNegocio.proveedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProveedorRepository extends JpaRepository <proveedor, Long> {
}
