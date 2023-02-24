package com.sitis.gestionusuariosbackend.dto;

import lombok.*;

@Data
@Builder
public class UsuarioResponse {
    private Long idUsuario;
    private String nombreUsuario;
    private String correo;
    private String perfil;
}
