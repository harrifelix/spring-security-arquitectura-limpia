package com.gco.producto.dominio.usecase.entities;

import java.util.Date;
public class Producto {

    private final int id;
    private final String nombre;
    private final String descripcion;
    private final double precio;
    private final int stock;
    private final String categoria;
    private final String codigo;
    private final Date fechacreacion;

    public Producto(int id, String nombre, String descripcion, double precio, int stock, String categoria, String codigo, Date fechacreacion) {
        this.id=id;
        this.nombre=nombre;
        this.descripcion = descripcion;
        this.precio=precio;
        this.stock=stock;
        this.categoria = categoria;
        this.codigo = codigo;
        this.fechacreacion = fechacreacion;
    }


    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public int getStock() {
        return stock;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getCodigo() {
        return codigo;
    }

    public Date getFechacreacion() {
        return fechacreacion;
    }


}
