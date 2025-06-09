package com.gco.producto.aplicacion.manejadores.producto;

import com.gco.producto.aplicacion.comando.ComandoProducto;
import com.gco.producto.aplicacion.fabrica.FabricaProducto;
import com.gco.producto.dominio.usecase.entities.Producto;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import  com.gco.producto.dominio.usecase.producto.*;

@Component
public class ManejadorActualizarProducto {

    private final ActualizarProductoUseCase crearProductoUseCase;
    private final FabricaProducto fabricaProducto;

    public ManejadorActualizarProducto(ActualizarProductoUseCase crearProductoUseCase, FabricaProducto fabricaProducto) {
        this.crearProductoUseCase = crearProductoUseCase;
        this.fabricaProducto = fabricaProducto;
    }

    @Transactional
    public void ejecutar(ComandoProducto comandoProducto) {
        Producto producto = this.fabricaProducto.crearProducto(comandoProducto);
        this.crearProductoUseCase.ejecutar(producto);
    }
}
