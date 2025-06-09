package com.gco.producto.aplicacion.comando;

import  com.gco.producto.dominio.usecase.entities.*;
import com.gco.producto.infraestructura.entrypoints.enums.*;
import java.util.Date;

public class ComandoMovimiento {

    private final int  id;
    private final int idProducto;
    private final TipoMovimientoEnum tipo ;
    private final int cantidad;
    private final Date fecha;
    private final String descripción;

    public ComandoMovimiento(int id,int idProducto,TipoMovimientoEnum tipo ,int cantidad,Date fecha,String descripción) {
        this.id=id;
        this.idProducto=idProducto;
        this.tipo=tipo;
        this.cantidad=cantidad;
        this.fecha=fecha;
        this.descripción=descripción;
    }


    public int getId() {
        return id;
    }

    public TipoMovimientoEnum getTipo() {
        return tipo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public Date getFecha() {
        return fecha;
    }

    public String getDescripción() {
        return descripción;
    }

    public int getIdProducto() {
        return idProducto;
    }
}

