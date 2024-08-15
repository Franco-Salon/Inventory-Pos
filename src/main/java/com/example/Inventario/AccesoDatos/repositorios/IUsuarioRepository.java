package com.example.Inventario.AccesoDatos.repositorios;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Inventario.EntidadesNegocio.Usuario;


@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Long> { 
}
