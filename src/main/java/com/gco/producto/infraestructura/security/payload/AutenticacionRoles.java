package com.gco.producto.infraestructura.security.payload;

public class AutenticacionRoles {

    private String rol;

    public AutenticacionRoles(){}

    public  AutenticacionRoles(String rol){
        this.rol=rol;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}
