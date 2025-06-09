package com.gco.producto.infraestructura.adapters.builder;

import com.gco.producto.dominio.usecase.entities.Producto;
import com.gco.producto.infraestructura.adapters.entidad.ProductoEntity;

public final class ProductoBuilder {

    private ProductoBuilder() {
    }

    public static Producto convertirToDominio(ProductoEntity productoEntity) {
        Producto producto = null;
        if (productoEntity != null) {
            producto = new Producto(productoEntity.getId(), productoEntity.getNombre(),
                    productoEntity.getDescripcion(),productoEntity.getPrecio(),
                    productoEntity.getStock(),productoEntity.getCategoria(), productoEntity.getCodigo(),
                    productoEntity.getFechacreacion() );
        }
        return producto;
    }


    public static ProductoEntity convertirToEntity(Producto producto) {
        ProductoEntity productoEntity = new ProductoEntity();
        productoEntity.setId(producto.getId());
        productoEntity.setNombre(producto.getNombre());
        productoEntity.setDescripcion(producto.getDescripcion());
        productoEntity.setPrecio(producto.getPrecio());
        productoEntity.setStock(producto.getStock());
        productoEntity.setCategoria(producto.getCategoria());
        productoEntity.setCodigo(producto.getCodigo());
        productoEntity.setFechacreacion(producto.getFechacreacion());
        return productoEntity;
    }
}
