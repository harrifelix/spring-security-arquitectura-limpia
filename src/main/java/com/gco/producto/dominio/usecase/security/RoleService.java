package com.gco.producto.dominio.usecase.security;
import com.gco.producto.infraestructura.adapters.entidad.Role;


import com.gco.producto.dominio.gateway.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gco.producto.infraestructura.adapters.repositorio.*;
import java.util.*;
import org.springframework.stereotype.Component;

/**
 * Clase que implementa los metodos de la interfaz {@link IRoleService} del servicio para los
 * roles.
 */
@Component
public class RoleService implements IRoleService{

    /**
     * Inyeccion para acceder a los metodos del repositorio
     */
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<Role> obtenerTodosRoles() {
        return (List<Role>) roleRepository.findAll();
    }

    @Override
    public Role buscarRolePorId(Integer idRole) {
        return roleRepository.findById(idRole).orElse(null);
    }
} // fin de la implementacion de la interfaz de servicios
