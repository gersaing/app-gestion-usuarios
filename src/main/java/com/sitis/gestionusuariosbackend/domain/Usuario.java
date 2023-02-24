package com.sitis.gestionusuariosbackend.domain;


import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_usuario")
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long id;

    @Column(name = "nombreusuario" )
    private String nombreUsuario;

    @Column(name = "correo" )
    private String correo;

    @Column(name = "clave" )
    private String clave;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_perfil")
    private Perfil perfil;

}
