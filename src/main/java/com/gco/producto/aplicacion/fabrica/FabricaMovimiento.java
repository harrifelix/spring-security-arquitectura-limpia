package com.gco.producto.aplicacion.fabrica;

import org.springframework.stereotype.Component;
import  com.gco.producto.dominio.usecase.entities.*;
import com.gco.producto.aplicacion.comando.*;

@Component
public class FabricaMovimiento {
    public Movimiento crearPrestamo(ComandoMovimiento comandoMovimiento) {
        return new Movimiento(comandoMovimiento.getId(),comandoMovimiento.getIdProducto()
                ,comandoMovimiento.getTipo(),comandoMovimiento.getCantidad()
                ,comandoMovimiento.getFecha(),comandoMovimiento.getDescripción());
    }
}
