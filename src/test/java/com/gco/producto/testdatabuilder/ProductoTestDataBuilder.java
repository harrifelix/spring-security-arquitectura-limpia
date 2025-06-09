package com.gco.producto.testdatabuilder;

import com.gco.producto.aplicacion.comando.*;
import com.gco.producto.dominio.usecase.entities.*;

import java.util.Date;

public class ProductoTestDataBuilder {

    private static  int id=0;
    private static  String nombre="ACEITE";
    private static  String descripcion="ACEITE 500 L ";
    private static  double precio=23.9;
    private static  int stock=2;
    private static  String categoria="GRANO";
    private static  String codigo="A01";
    private static  Date fechacreacion =new Date();

    public ProductoTestDataBuilder conNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public ProductoTestDataBuilder conDescripcion(String descripcion) {
        this.descripcion = descripcion;
        return this;
    }

    public ProductoTestDataBuilder conPrecio(double precio) {
        this.precio = precio;
        return this;
    }

    public ProductoTestDataBuilder conStock(int stock) {
        this.stock = stock;
        return this;
    }

    public ProductoTestDataBuilder conCategoria(String categoria) {
        this.categoria = categoria;
        return this;
    }

    public ProductoTestDataBuilder conCodigo(String codigo) {
        this.codigo = codigo;
        return this;
    }

    public ProductoTestDataBuilder conFechaCreacion(Date fechaCreacion) {
        this.fechacreacion = fechaCreacion;
        return this;
    }

    public Producto build() {
        return new Producto(id, nombre, descripcion,precio,stock
        ,categoria,codigo, fechacreacion);
    }

    public ComandoProducto buildComando() {
        return new ComandoProducto(id, nombre, descripcion,precio,stock
                ,categoria,codigo, fechacreacion);
    }
}
