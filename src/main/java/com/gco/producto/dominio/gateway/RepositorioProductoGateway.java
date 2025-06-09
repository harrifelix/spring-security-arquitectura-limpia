package com.gco.producto.dominio.gateway;

import com.gco.producto.dominio.usecase.entities.Producto;

import java.util.List;

public interface RepositorioProductoGateway {

    int agregar(Producto producto);

    void actualizar(Producto producto);

    void eliminar(String id);

    Producto obtenerById(String id);

    List<Producto> getAll();


    Producto obtenerByNombre(String id) ;


    Producto obtenerByCodigo(String id);


    Producto obtenerByCategoria(String id) ;


}