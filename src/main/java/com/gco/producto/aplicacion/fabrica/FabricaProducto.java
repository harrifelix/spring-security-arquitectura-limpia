package com.gco.producto.aplicacion.fabrica;

import com.gco.producto.aplicacion.comando.ComandoProducto;
import com.gco.producto.dominio.usecase.entities.Producto;
import org.springframework.stereotype.Component;

@Component
public class FabricaProducto {
    public Producto crearProducto(ComandoProducto comandoProducto) {
        return new Producto(
                comandoProducto.getId(), comandoProducto.getNombre()
                , comandoProducto.getDescripcion(), comandoProducto.getPrecio(), comandoProducto.getStock()
                , comandoProducto.getCategoria(), comandoProducto.getCodigo(), comandoProducto.getFechaCreacion());

    }
}
