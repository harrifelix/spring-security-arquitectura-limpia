package com.gco.producto.infraestructura.security.payload;

import java.io.Serializable;
import java.util.*;
import org.springframework.security.core.GrantedAuthority;
public class AutenticacionResponse implements Serializable {
    private static final long serialVersionUID = 1L;

    private String token;

    private String username;

    private List<GrantedAuthority> roles;
    public AutenticacionResponse(String token, String username, List<GrantedAuthority> roles){
        this.token = token;
        this.username = username;
        this.roles = roles;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<GrantedAuthority> getRoles() {
        return roles;
    }

    public void setRoles(List<GrantedAuthority> roles) {
        this.roles = roles;
    }
}
