package com.gco.producto.aplicacion.manejadores.producto;

import com.gco.producto.dominio.usecase.entities.Producto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.gco.producto.dominio.usecase.producto.*;
import java.util.*;

@Service
public class ManejadorObtenerProductos {

    private final ObtenerProductosUseCase servicioObtenerProducto;

    public ManejadorObtenerProductos(ObtenerProductosUseCase servicioObtenerProducto) {
        this.servicioObtenerProducto = servicioObtenerProducto;
    }

    @Transactional
    public List<Producto> ejecutar() {
        return this.servicioObtenerProducto.ejecutar();
    }
}
