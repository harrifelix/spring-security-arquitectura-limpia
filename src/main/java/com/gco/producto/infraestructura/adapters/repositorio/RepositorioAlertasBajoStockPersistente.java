package com.gco.producto.infraestructura.adapters.repositorio;
import com.gco.producto.infraestructura.adapters.entidad.*;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class RepositorioAlertasBajoStockPersistente {

    private final EntityManager entityManager;

    public RepositorioAlertasBajoStockPersistente(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void agregar(AlertasBajoStockEntity alertasBajoStockEntity) {
       try {
           entityManager.persist(alertasBajoStockEntity);
           entityManager.flush();
       }
       catch(Exception ex){
           System.out.println(ex.getMessage());
       }
    }
}
