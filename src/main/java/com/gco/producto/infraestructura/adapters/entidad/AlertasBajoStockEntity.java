package com.gco.producto.infraestructura.adapters.entidad;

import javax.persistence.*;

@Entity(name = "AlertasBajoStock")
@NamedQueries({
        @NamedQuery(name = "AlertaBajoStock.findById", query = "SELECT alerta from AlertasBajoStock alerta where alerta.id = :id"),
        @NamedQuery(name = "AlertaBajoStock.findAll", query = "SELECT alerta from AlertasBajoStock alerta")
})
public class AlertasBajoStockEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private int idProducto;
    @Column(nullable = false)
    private int  stock;
    @Column(nullable = false)
    private String descripcion;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
