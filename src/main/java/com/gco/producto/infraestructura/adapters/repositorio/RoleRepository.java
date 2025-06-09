package com.gco.producto.infraestructura.adapters.repositorio;
import org.springframework.stereotype.Repository;
import com.gco.producto.infraestructura.adapters.entidad.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Este repositorio extiende de {@link JpaRepository} que permite usar los metodos
 * para las operaciones basicas de un CRUD que se haran hacia la tabla de <b>roles</b>.
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

} // fin del repositorio
