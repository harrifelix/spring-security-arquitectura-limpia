package com.gco.producto.aplicacion.manejadores.movimiento;

import com.gco.producto.aplicacion.comando.*;
import  com.gco.producto.dominio.usecase.entities.*;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import  com.gco.producto.dominio.usecase.movimiento.*;
import  com.gco.producto.aplicacion.fabrica.*;

@Component
public class ManejadorCrearMovimiento {

    private final CrearMovimientoUseCase crearMovimientoUseCase;
    private final FabricaMovimiento fabricaMovimiento;

    public ManejadorCrearMovimiento(CrearMovimientoUseCase crearMovimientoUseCase, FabricaMovimiento fabricaMovimiento) {
        this.crearMovimientoUseCase = crearMovimientoUseCase;
        this.fabricaMovimiento = fabricaMovimiento;
    }

    @Transactional
    public void ejecutar(ComandoMovimiento comandoMovimiento) {
        Movimiento producto = this.fabricaMovimiento.crearPrestamo(comandoMovimiento);
        this.crearMovimientoUseCase.ejecutar(producto);
    }
}
