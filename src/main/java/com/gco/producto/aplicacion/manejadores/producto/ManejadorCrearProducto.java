package com.gco.producto.aplicacion.manejadores.producto;

import com.gco.producto.aplicacion.comando.ComandoProducto;
import com.gco.producto.aplicacion.fabrica.FabricaProducto;
import com.gco.producto.dominio.usecase.entities.Producto;
import com.gco.producto.dominio.usecase.producto.CrearProductoUseCase;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class ManejadorCrearProducto {

    private final CrearProductoUseCase crearProductoUseCase;
    private final FabricaProducto fabricaProducto;

    public ManejadorCrearProducto(CrearProductoUseCase crearProductoUseCase, FabricaProducto fabricaProducto) {
        this.crearProductoUseCase = crearProductoUseCase;
        this.fabricaProducto = fabricaProducto;
    }

    @Transactional
    public int ejecutar(ComandoProducto comandoProducto) {
        Producto producto = this.fabricaProducto.crearProducto(comandoProducto);
       return this.crearProductoUseCase.ejecutar(producto);
    }
}
