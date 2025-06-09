package com.gco.producto.infraestructura.adapters.repositorio;

import com.gco.producto.dominio.usecase.entities.Movimiento;
import com.gco.producto.dominio.gateway.*;
import com.gco.producto.infraestructura.adapters.builder.*;
import com.gco.producto.infraestructura.adapters.entidad.*;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Repository
public class RepositorioMovimientoPersistente implements RepositorioMovimientoGateway {

    private static final String PRODUCTO_FIND_BY_ALL = "Movimiento.findAll";

    private final EntityManager entityManager;

    public RepositorioMovimientoPersistente(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void agregar(Movimiento movimiento) {
        MovimientoEntity movimientoEntity = MovmientoBuilder.convertirToEntity(movimiento);
       try {
           entityManager.persist(movimientoEntity);
           entityManager.flush();
       }
       catch(Exception ex){
           System.out.println(ex.getMessage());
       }
    }

    @Override
    public List<Movimiento> getAll() {

        List<MovimientoEntity> movimientoEntity =  obtenerTodos();
        List<Movimiento> listProducto=new ArrayList<Movimiento>();
        if (movimientoEntity == null) {
            return null;
        }
        for (MovimientoEntity p:movimientoEntity
        ) {
            int id = Math.toIntExact(p.getId());

            Movimiento   movimiento = new Movimiento(id,
                    p.getIdProducto(),p.getTipo()
                    ,p.getCantidad(),p.getFecha(),p.getDescripcion());

            listProducto.add(movimiento);
        }
        return  listProducto;
    }

    private List<MovimientoEntity> obtenerTodos() {

        Query query = entityManager.createNamedQuery(PRODUCTO_FIND_BY_ALL);
        List resultList = query.getResultList();

        return !resultList.isEmpty() ? (List<MovimientoEntity>) resultList: null;
    }
}
