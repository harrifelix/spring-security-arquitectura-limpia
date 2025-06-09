package com.gco.producto.aplicacion.manejadores.producto;

import com.gco.producto.dominio.usecase.entities.Producto;
import com.gco.producto.dominio.usecase.producto.ObtenerProductoUseCase;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ManejadorObtenerProductoById {

    private final ObtenerProductoUseCase servicioObtenerProducto;

    public ManejadorObtenerProductoById(ObtenerProductoUseCase servicioObtenerProducto) {
        this.servicioObtenerProducto = servicioObtenerProducto;
    }

    @Transactional
    public Producto ejecutar(String id) {
        return this.servicioObtenerProducto.ejecutar(id);
    }
}
