package com.sitis.gestionusuariosbackend.services.impl;

import com.sitis.gestionusuariosbackend.common.Constants;
import com.sitis.gestionusuariosbackend.domain.Perfil;
import com.sitis.gestionusuariosbackend.domain.Usuario;
import com.sitis.gestionusuariosbackend.dto.Login;
import com.sitis.gestionusuariosbackend.dto.UsuarioRequest;
import com.sitis.gestionusuariosbackend.dto.UsuarioResponse;
import com.sitis.gestionusuariosbackend.exception.ApplicationException;
import com.sitis.gestionusuariosbackend.mapper.UsuarioMapper;
import com.sitis.gestionusuariosbackend.repository.PerfilRepository;
import com.sitis.gestionusuariosbackend.repository.UsuarioRepository;
import com.sitis.gestionusuariosbackend.services.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {
    private UsuarioRepository usuarioRepository;
    private PerfilRepository perfilRepository;

    @Override
    public UsuarioResponse crearUsuario(UsuarioRequest usuarioRequest) {

        Usuario usuario = usuarioRepository.obtenerUsuario(usuarioRequest.getNombreUsuario()).orElse(null);
        if(usuario!=null){
            throw new ApplicationException(Constants.ERROR_USUARIO_EXISTENTE);
        }

        Perfil perfil = perfilRepository.findById(usuarioRequest.getPerfil())
                .orElseThrow(() -> new ApplicationException(Constants.ERROR_PERFIL)) ;
        usuario = new Usuario();
        usuario.setNombreUsuario(usuarioRequest.getNombreUsuario());
        usuario.setCorreo(usuarioRequest.getCorreoElectronico());
        usuario.setClave(usuarioRequest.getClave());
        usuario.setPerfil(perfil);

        return UsuarioMapper.mapearResponse(usuarioRepository.save(usuario));
    }

    @Override
    public UsuarioResponse validarCredenciles(Login login) {
        Usuario usuario = usuarioRepository.validarCredenciales(login.getNombreUsuario(),login.getClave())
                .orElseThrow(() -> new ApplicationException(Constants.ERROR_CREDENCIALES));

        return UsuarioMapper.mapearResponse(usuario);
    }

    @Override
    public Page<Usuario> findAll(Pageable pageable) {

        return usuarioRepository.findAll(pageable);
    }

    @Override
    public List<UsuarioResponse> finAll() {
        List<Usuario>usuarios = usuarioRepository.findAll();
        return  usuarios.stream().map(UsuarioMapper::mapearResponse).collect(Collectors.toList());
    }


}
