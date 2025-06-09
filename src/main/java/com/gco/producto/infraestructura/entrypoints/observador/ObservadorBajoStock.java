package com.gco.producto.infraestructura.entrypoints.observador;
import   com.gco.producto.infraestructura.adapters.repositorio.*;
import org.springframework.stereotype.*;
import org.springframework.beans.factory.annotation.Autowired;
import  com.gco.producto.infraestructura.adapters.entidad.*;
@Component
public class ObservadorBajoStock implements  IObservador{

    @Autowired
   private  RepositorioAlertasBajoStockPersistente repositorioAlertasBajoStockPersistente;

    @Override
    public void Update(ISujeto sujeto) {

        AlertasBajoStockEntity alertasBajoStockEntity =new AlertasBajoStockEntity();
        alertasBajoStockEntity.setDescripcion("Poner cuidado se esta agontando ,hay que sumistrar lo antes posible el producto");
        alertasBajoStockEntity.setIdProducto(sujeto.getIdProducto());
        alertasBajoStockEntity.setStock(sujeto.getStock());
        repositorioAlertasBajoStockPersistente.agregar(alertasBajoStockEntity);
    }
}
