package com.gco.producto.infraestructura.entrypoints;

import com.gco.producto.aplicacion.comando.ComandoMovimiento;
import com.gco.producto.aplicacion.comando.ComandoProducto;
import com.gco.producto.aplicacion.manejadores.movimiento.*;
import com.gco.producto.aplicacion.manejadores.producto.*;
import com.gco.producto.dominio.usecase.entities.*;
import com.gco.producto.infraestructura.entrypoints.enums.TipoMovimientoEnum;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("/movimiento")
@CrossOrigin("*")
public class ControladorMovimiento {
    private final ManejadorListarMovimiento
            manejadorListarMovimiento;

    public ControladorMovimiento( ManejadorListarMovimiento
                                          manejadorListarMovimiento) {
      this.manejadorListarMovimiento=manejadorListarMovimiento;
    }

    @GetMapping()
    public List<Movimiento> listarMovimientos() {
        return this.manejadorListarMovimiento.ejecutar();
    }

}
