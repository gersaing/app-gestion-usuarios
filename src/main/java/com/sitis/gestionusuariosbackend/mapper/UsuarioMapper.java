package com.sitis.gestionusuariosbackend.mapper;

import com.sitis.gestionusuariosbackend.common.Constants;
import com.sitis.gestionusuariosbackend.domain.Usuario;
import com.sitis.gestionusuariosbackend.dto.UsuarioResponse;

public class UsuarioMapper {
    private UsuarioMapper() {
        throw new IllegalStateException(Constants.UTILITY_CLASS);
    }

    public static UsuarioResponse mapearResponse(Usuario usuario) {
        return UsuarioResponse.builder().idUsuario(usuario.getId())
                .nombreUsuario(usuario.getNombreUsuario())
                .correo(usuario.getCorreo())
                .perfil(usuario.getPerfil().getDescripcion())
                .build();
    }

}
