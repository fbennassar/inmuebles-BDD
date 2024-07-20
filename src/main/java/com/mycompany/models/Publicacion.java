package com.mycompany.models;

import java.sql.Date;

public class Publicacion {

	private int id;
	private Date fecha;
	private int idCliente;
	private Double precio;
	private String descripcion;
	private int idPropiedad;
	private int idEmpleado;
	private int idTipoInmueble;
	private boolean disponible;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getIdPropiedad() {
		return idPropiedad;
	}
	public void setIdPropiedad(int idPropiedad) {
		this.idPropiedad = idPropiedad;
	}
	public int getIdEmpleado() {
		return idEmpleado;
	}
	public void setIdEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
	}
	public int getIdTipoInmueble() {
		return idTipoInmueble;
	}
	public void setIdTipoInmueble(int idTipoInmueble) {
		this.idTipoInmueble = idTipoInmueble;
	}
	public boolean isDisponible() {
		return disponible;
	}
	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}
	
	
}
