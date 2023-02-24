package com.sitis.gestionusuariosbackend.dto;

import lombok.*;

@Data
@Builder
public class UsuarioRequest {

    private String nombreUsuario;
    private String correoElectronico;
    private String clave;
    private Long perfil;
}
