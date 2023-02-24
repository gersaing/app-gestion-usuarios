package com.sitis.gestionusuariosbackend.controller;

import com.sitis.gestionusuariosbackend.domain.Usuario;
import com.sitis.gestionusuariosbackend.dto.Login;
import com.sitis.gestionusuariosbackend.dto.UsuarioRequest;
import com.sitis.gestionusuariosbackend.dto.UsuarioResponse;
import com.sitis.gestionusuariosbackend.services.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200/")
public class UsuarioController {
    private UsuarioService usuarioService;

    @GetMapping("/usuarios-paginas")
    public Page<Usuario>paginasUsuarios(
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "10") Integer size)
    {
        Page<Usuario> paginaUsuarios = usuarioService.findAll(PageRequest.of(page,size));

        return paginaUsuarios;
    }

    @GetMapping("/usuarios")
    public List<UsuarioResponse> listaDeUsuarios(){
        return usuarioService.finAll();
    }

    @PostMapping("/usuarios")
    public UsuarioResponse crearUsuario(@RequestBody UsuarioRequest usuarioRequest) {
        System.out.println("impr: "+usuarioRequest.toString());
        return usuarioService.crearUsuario(usuarioRequest);
    }
    @PostMapping("/validar-credenciales")
    public UsuarioResponse validarCredenciales(@RequestBody Login login) {
        return usuarioService.validarCredenciles(login);
    }


}
