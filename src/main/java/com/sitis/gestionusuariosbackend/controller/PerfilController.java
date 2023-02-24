package com.sitis.gestionusuariosbackend.controller;

import com.sitis.gestionusuariosbackend.domain.Perfil;
import com.sitis.gestionusuariosbackend.services.PerfilService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200/")
public class PerfilController {
    private PerfilService perfilService;
    @GetMapping("/perfiles")
    public List<Perfil> getTipoRecepcion() {
        return perfilService.listarPerfiles();
    }
}
