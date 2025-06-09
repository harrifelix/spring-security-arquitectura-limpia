package com.gco.producto.infraestructura.adapters.entidad;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "Producto")
@NamedQueries({
		@NamedQuery(name = "Producto.findById", query = "SELECT producto from Producto producto where producto.id = :id"),
		@NamedQuery(name = "Producto.findByNombre", query = "SELECT producto from Producto producto where producto.nombre = :nombre"),
		@NamedQuery(name = "Producto.findByCategoria", query = "SELECT producto from Producto producto where producto.categoria = :categoria"),
		@NamedQuery(name = "Producto.findByCodigo", query = "SELECT producto from Producto producto where producto.codigo = :codigo"),
		@NamedQuery(name = "Producto.findAll", query = "SELECT producto from Producto producto")
})
public class ProductoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private  int id;

	@Column(nullable = false)
	private  String nombre;

	@Column(nullable = false)
	private  String descripcion;

	@Column(nullable = false)
	private  double precio;

	@Column(nullable = false)
	private  int stock;

	@Column(nullable = false)

	private  String categoria;

	@Column(nullable = false)
	private  String codigo;

	@Column(nullable = false)
	private Date fechacreacion;
	public ProductoEntity(int id, String nombre, String descripcion, double precio, int stock, String categoria, String codigo, Date fechacreacion) {
		this.setId(id);
		this.setNombre(nombre);
		this.setDescripcion(descripcion);
		this.setPrecio(precio);
		this.setStock(stock);
		this.setCategoria(categoria);
		this.setCodigo(codigo);
		this.setFechacreacion(fechacreacion);
	}

	public ProductoEntity(){}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Date getFechacreacion() {
		return fechacreacion;
	}

	public void setFechacreacion(Date fechacreacion) {
		this.fechacreacion = fechacreacion;
	}
}