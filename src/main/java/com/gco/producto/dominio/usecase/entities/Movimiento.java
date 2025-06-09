package com.gco.producto.dominio.usecase.entities;

import java.util.Date;
import  com.gco.producto.infraestructura.entrypoints.enums.*;

public class Movimiento {

    private final int  id;
    private final int idProducto;
    private final TipoMovimientoEnum tipo ;
    private final int cantidad;
    private final Date fecha;
    private final String descripcion;

    public Movimiento(int id,int idProducto,TipoMovimientoEnum tipo ,int cantidad,Date fecha,String descripcion) {
        this.id=id;
        this.idProducto=idProducto;
        this.tipo=tipo;
        this.cantidad=cantidad;
        this.fecha=fecha;
        this.descripcion = descripcion;
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

    public String getDescripcion() {
        return descripcion;
    }

    public int getIdProducto() {
        return idProducto;
    }
}
