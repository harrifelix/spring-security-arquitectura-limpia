package com.gco.producto.aplicacion.manejadores.producto;

import com.gco.producto.dominio.usecase.entities.Producto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.gco.producto.dominio.usecase.producto.*;

@Service
public class ManejadorObtenerProductoByNombre {

    private final ObtenerProductoByNombreUseCase servicioObtenerProducto;

    public ManejadorObtenerProductoByNombre(ObtenerProductoByNombreUseCase servicioObtenerProducto) {
        this.servicioObtenerProducto = servicioObtenerProducto;
    }

    @Transactional
    public Producto ejecutar(String isbn) {
        return this.servicioObtenerProducto.ejecutar(isbn);
    }
}
