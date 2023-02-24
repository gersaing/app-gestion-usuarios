package com.sitis.gestionusuariosbackend.repository;

import com.sitis.gestionusuariosbackend.domain.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.Optional;


@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    @Query("SELECT us FROM Usuario us WHERE us.nombreUsuario= ?1")
    Optional<Usuario> obtenerUsuario(String nombreUsuario);

    @Query("SELECT us FROM Usuario us WHERE us.nombreUsuario= ?1 and us.clave=?2")
    Optional<Usuario> validarCredenciales(String nombreUsuario, String clave);

}
