package com.gco.producto.infraestructura.adapters.entidad;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Esta clase representa a la tabla de la BD llamada <b>usuarios</b>
 * en la cual las propiedades definidas aqui seran mapeadas a la tabla.
 * Ya que existe una relacion de Muchos a Muchos con la Tabla roles se genera la relacion
 * @ManyToMany con la tabla {@link Role}.
 */


public class UsuarioRoles implements Serializable {
    private static final long serialVersionUID = 1L;

    /* ~ Propiedades
    ==================================== */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    private Integer id_usuario;

    @NotNull
    private String id_role;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Integer id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getId_role() {
        return id_role;
    }

    public void setId_role(String id_role) {
        this.id_role = id_role;
    }
} // fin de la clase entidad
