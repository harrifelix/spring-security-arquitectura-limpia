package com.gco.producto.aplicacion.manejadores.movimiento;

import java.util.List;
import com.gco.producto.dominio.usecase.entities.*;
import com.gco.producto.dominio.usecase.movimiento.*;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import com.gco.producto.aplicacion.fabrica.*;

@Component
public class ManejadorListarMovimiento {
    private final ListarMovimientoUseCase listarMovimientoUseCase;
    private final FabricaMovimiento movimientoFactory;

    public ManejadorListarMovimiento( ListarMovimientoUseCase listarMovimientoUseCase, FabricaMovimiento movimientoFactory) {
        this.listarMovimientoUseCase = listarMovimientoUseCase;
        this.movimientoFactory = movimientoFactory;
    }

    @Transactional
    public List<Movimiento> ejecutar() {
        return this.listarMovimientoUseCase.ejecutar();
    }
}
