package com.sitis.gestionusuariosbackend.repository;


import com.sitis.gestionusuariosbackend.domain.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerfilRepository extends JpaRepository<Perfil, Long> {

}
