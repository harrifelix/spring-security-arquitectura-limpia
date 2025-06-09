package com.gco.producto.dominio.usecase.movimiento;


import com.gco.producto.dominio.gateway.*;
import org.springframework.stereotype.Component;
import  com.gco.producto.dominio.usecase.entities.*;
@Component
public class CrearMovimientoUseCase {

    private final RepositorioMovimientoGateway repositorioMovimientoGateway;

    public CrearMovimientoUseCase(RepositorioMovimientoGateway repositorioMovimientoGateway) {
        this.repositorioMovimientoGateway = repositorioMovimientoGateway;
    }

    public void ejecutar(Movimiento movimiento) {
        this.repositorioMovimientoGateway.agregar(movimiento);
    }
}
