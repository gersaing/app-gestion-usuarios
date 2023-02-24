package com.sitis.gestionusuariosbackend.domain;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_perfil")
public class Perfil implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_perfil")
    private Long id;

    @Column(name = "descripcion" )
    private String descripcion;

    @OneToMany(mappedBy = "perfil",  cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Usuario> usuarios;
}
