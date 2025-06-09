package com.gco.producto.infraestructura.entrypoints.observador;

public interface ISujeto {

     void Attach(IObservador observador);

     void Detach(IObservador observador);

     void Notify();

      int getStock();

      int getIdProducto();
}
