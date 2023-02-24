package com.sitis.gestionusuariosbackend.services.impl;

import com.sitis.gestionusuariosbackend.domain.Perfil;
import com.sitis.gestionusuariosbackend.repository.PerfilRepository;
import com.sitis.gestionusuariosbackend.services.PerfilService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
public class PerfilServiceImpl implements PerfilService {
    private PerfilRepository perfilRepository;
    @Override
    public List<Perfil> listarPerfiles() {
        return perfilRepository.findAll();
    }
}
