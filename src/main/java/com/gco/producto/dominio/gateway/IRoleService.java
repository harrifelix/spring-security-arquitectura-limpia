package com.gco.producto.dominio.gateway;


import java.util.List;
import com.gco.producto.infraestructura.adapters.entidad.Role;

/**
 * Permite envolver los metodos del la interfaz del repositorio que extiende
 * de {@link org.springframework.data.jpa.repository.JpaRepository} renombrando
 * estos metodos a unos mas comodos, ademas de no trabajar directamente sobre el
 * repositorio.
 */
public interface IRoleService {

    /**
     * Envuelve al metodo <b>findAll</b> de <b>JpaRepository</b>
     * el cual devuelve todos los registros de la tabla <b>roles</b>
     * @return List(Role)
     */
    List<Role> obtenerTodosRoles();

    /**
     * Envuelve al metodo <b>findById</b> de <b>JpaRepository</b>
     * el cual retorna el registro buscado por su id.
     * @param idRole
     * @return Role
     */
    Role buscarRolePorId(Integer idRole);

} // fin de la interface de servicio
