package com.sitis.gestionusuariosbackend.services;

import com.sitis.gestionusuariosbackend.domain.Usuario;
import com.sitis.gestionusuariosbackend.dto.Login;
import com.sitis.gestionusuariosbackend.dto.UsuarioRequest;
import com.sitis.gestionusuariosbackend.dto.UsuarioResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public interface UsuarioService  {
    UsuarioResponse crearUsuario(UsuarioRequest usuarioRequest);
    UsuarioResponse validarCredenciles(Login login);

    Page<Usuario> findAll(Pageable pageable) ;
    List<UsuarioResponse> finAll();
}
