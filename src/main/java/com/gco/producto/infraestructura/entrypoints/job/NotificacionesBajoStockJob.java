package com.gco.producto.infraestructura.entrypoints.job;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import  com.gco.producto.infraestructura.entrypoints.observador.*;
import com.gco.producto.infraestructura.adapters.repositorio.*;
import com.gco.producto.dominio.usecase.entities.*;
import java.util.*;
@Component
public class NotificacionesBajoStockJob {

    private final int PARAMETRO_BAJO_STOCK=10;
   private RepositorioProductoPersistente repositorioProductoPersistente;

   public  NotificacionesBajoStockJob(RepositorioProductoPersistente repositorioProductoPersistente){
       this.repositorioProductoPersistente=repositorioProductoPersistente;
   }

    /**
     * Tarea programada para calcular el bajo stock de un producto
     */

    /**
     * este metodo ejecuta un observador para notificar bajo stock a sus observadores puede tener
     * los observadores que desee en este caso solo hay un observador
     */
    //@Scheduled(cron = "0 * * * * ?")
    public void verificarBajoStock(){

        List<Producto> productoList=repositorioProductoPersistente.getAll();

        for (Producto producto:productoList){

            if(producto.getStock()<=PARAMETRO_BAJO_STOCK){
                SujetoImp sujetoImp =new   SujetoImp();
                ObservadorBajoStock observadorBajoStock=new ObservadorBajoStock();

                //Implemente los observadores que desee que escuchen bajo stock.
                sujetoImp.Attach(observadorBajoStock);
                sujetoImp.setStock(producto.getStock());
                //Se genera la notificacion de bajo stock a los observadores
                sujetoImp.NotificarStockBajo();
            }
        }
    }
}
