package com.gco.producto.dominio.usecase.security;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import com.gco.producto.infraestructura.adapters.entidad.*;
/**
 * Esta clase proporciona la implementacion para establecer informacion del usuario.
 * Almacenando información del usuario que más tarde se encapsula en objetos de autenticación
 */
public class DetalleUsuarioSecurityUseCase implements UserDetails {
    /* ~ Propiedades
    ==================================== */
    private String username;
    private String password;
    private boolean active;
    private List<SimpleGrantedAuthority> authorities;

    /* ~ Metodos
    ==================================== */
    public DetalleUsuarioSecurityUseCase(Usuario usuario){
        this.authorities = new ArrayList<SimpleGrantedAuthority>();
        this.username = usuario.getUsername();
        this.password = usuario.getPassword();
        this.active = usuario.isActivo();
        for(Role role : usuario.getRoles()){
            authorities.add(new SimpleGrantedAuthority("ROLE_"+role.getNombreRole()));
        } // fin del barrido
    } // fin del constructor

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return this.active;
    }
} // fin de la clase details
