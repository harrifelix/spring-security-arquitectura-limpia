package com.gco.producto.infraestructura.entrypoints.observador;

import java.util.*;
public class SujetoImp implements ISujeto{

    private int Stock;

    private int idProducto;

    private List<IObservador> observadors=new ArrayList<>();

    @Override
    public void Attach(IObservador observador) {
        this.observadors.add(observador);
    }

    @Override
    public void Detach(IObservador observador) {
          this.observadors.remove(observador);
    }

    @Override
    public void Notify() {

        for (IObservador ob:observadors) {
            ob.Update(this);
        }
    }

    public  void NotificarStockBajo(){

        System.out.println("Se comienza la notificacion de stock bajo a los observadores");
        this.Notify();
    }

    public int getStock() {
        return Stock;
    }

    public void setStock(int stock) {
        Stock = stock;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }
}
