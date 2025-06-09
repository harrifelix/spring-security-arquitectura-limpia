package com.gco.producto.infraestructura.adapters.builder;

import com.gco.producto.dominio.usecase.entities.*;
import com.gco.producto.infraestructura.adapters.entidad.*;

public final class MovmientoBuilder {

    private MovmientoBuilder() {
    }

    public static Movimiento convertirToDominio(MovimientoEntity movimientoEntity) {
        Movimiento movimiento = null;

        if (movimientoEntity != null) {
            int id = Math.toIntExact(movimientoEntity.getId());


            movimiento = new Movimiento(id,
                    movimiento.getIdProducto(), movimientoEntity.getTipo()
            ,movimientoEntity.getCantidad(),movimientoEntity.getFecha(),movimientoEntity.getDescripcion());
        }
        return movimiento;
    }


    public static MovimientoEntity convertirToEntity(Movimiento movimiento) {
        MovimientoEntity movimientoEntity = new MovimientoEntity();
        movimientoEntity.setCantidad(movimiento.getId());
        movimientoEntity.setIdProducto(movimientoEntity.getIdProducto());
        movimientoEntity.setTipo(movimiento.getTipo());
        movimientoEntity.setCantidad(movimiento.getCantidad());
        movimientoEntity.setFecha(movimiento.getFecha());
        movimientoEntity.setDescripcion(movimiento.getDescripcion());

        return movimientoEntity;
    }
}
