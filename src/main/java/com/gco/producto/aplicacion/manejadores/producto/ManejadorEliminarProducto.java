package com.gco.producto.aplicacion.manejadores.producto;

import com.gco.producto.dominio.usecase.producto.*;
import com.gco.producto.aplicacion.fabrica.FabricaProducto;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class ManejadorEliminarProducto {

    private final EliminarProductoUseCase eliminarProductoUseCase;
    private final FabricaProducto fabricaProducto;

    public ManejadorEliminarProducto(EliminarProductoUseCase eliminarProductoUseCase, FabricaProducto fabricaProducto) {
        this.eliminarProductoUseCase = eliminarProductoUseCase;
        this.fabricaProducto = fabricaProducto;
    }

    @Transactional
    public void ejecutar(String id) {
        this.eliminarProductoUseCase.ejecutar(id);
    }
}
