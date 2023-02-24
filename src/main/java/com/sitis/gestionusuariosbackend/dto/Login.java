package com.sitis.gestionusuariosbackend.dto;

import lombok.*;

@Data
@Builder
public class Login {
    private String nombreUsuario;
    private String clave;
}
