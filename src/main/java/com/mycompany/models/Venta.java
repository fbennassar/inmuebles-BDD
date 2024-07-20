package com.mycompany.models;

import java.sql.Date;

public class Venta {

	private int id;
	private Date fechaVenta;
	private int idCliente;
	private int idEmpleado;
	private int idPublicacion;
	private int idPropiedad;
	private int IdTipoInmueble;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getFechaVenta() {
		return fechaVenta;
	}
	public void setFechaVenta(Date fechaVenta) {
		this.fechaVenta = fechaVenta;
	}
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public int getIdEmpleado() {
		return idEmpleado;
	}
	public void setIdEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
	}
	public int getIdPublicacion() {
		return idPublicacion;
	}
	public void setIdPublicacion(int idPublicacion) {
		this.idPublicacion = idPublicacion;
	}
	public int getIdPropiedad() {
		return idPropiedad;
	}
	public void setIdPropiedad(int idPropiedad) {
		this.idPropiedad = idPropiedad;
	}
	public int getIdTipoInmueble() {
		return IdTipoInmueble;
	}
	public void setIdTipoInmueble(int idTipoInmueble) {
		IdTipoInmueble = idTipoInmueble;
	}
	
	
}
