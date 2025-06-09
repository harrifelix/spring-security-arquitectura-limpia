package com.gco.producto.aplicacion.manejadores.producto;

import com.gco.producto.dominio.usecase.entities.Producto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.gco.producto.dominio.usecase.producto.*;


@Service
public class ManejadorObtenerProductoByCategoria {

    private final ObtenerProductoByCategoriaUseCase servicioObtenerProducto;

    public ManejadorObtenerProductoByCategoria(ObtenerProductoByCategoriaUseCase servicioObtenerProducto) {
        this.servicioObtenerProducto = servicioObtenerProducto;
    }

    @Transactional
    public Producto ejecutar(String isbn) {
        return this.servicioObtenerProducto.ejecutar(isbn);
    }
}
