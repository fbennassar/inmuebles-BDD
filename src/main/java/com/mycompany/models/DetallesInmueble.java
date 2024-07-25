package com.mycompany.models;

import java.sql.Date;

public class DetallesInmueble {

	private int idPublicacion;
	private Date fechaPublicacion;
	private int idPropiedad;
	private int idTipoInmueble;
	private String nombreTipo;
	private String nombreCliente;
	private double precio;
	private String descripcion;
	private int idEmpleado;
	private String nombreEmpleado;
	private String telefonoEmpleado;
	private String nombreEstado;
	private String nombreMunicipio;
	private String nombreAvenidas;
	private int calles;
	private int avenidas;
	private String nombreCalles;
	private String detalle;
	private int codigoPostal;
	public int getIdPublicacion() {
		return idPublicacion;
	}
	public void setIdPublicacion(int idPublicacion) {
		this.idPublicacion = idPublicacion;
	}
	public Date getFechaPublicacion() {
		return fechaPublicacion;
	}
	public void setFechaPublicacion(Date fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}
	public String getNombreTipo() {
		return nombreTipo;
	}
	public void setNombreTipo(String nombreTipo) {
		this.nombreTipo = nombreTipo;
	}
	public String getNombreCliente() {
		return nombreCliente;
	}
	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getNombreEmpleado() {
		return nombreEmpleado;
	}
	public void setNombreEmpleado(String nombreEmpleado) {
		this.nombreEmpleado = nombreEmpleado;
	}
	public String getTelefonoEmpleado() {
		return telefonoEmpleado;
	}
	public void setTelefonoEmpleado(String telefonoEmpleado) {
		this.telefonoEmpleado = telefonoEmpleado;
	}
	public String getNombreEstado() {
		return nombreEstado;
	}
	public void setNombreEstado(String nombreEstado) {
		this.nombreEstado = nombreEstado;
	}
	public String getNombreMunicipio() {
		return nombreMunicipio;
	}
	public void setNombreMunicipio(String nombreMunicipio) {
		this.nombreMunicipio = nombreMunicipio;
	}
	public String getNombreAvenidas() {
		return nombreAvenidas;
	}
	public void setNombreAvenidas(String nombreAvenidas) {
		this.nombreAvenidas = nombreAvenidas;
	}
	public String getNombreCalles() {
		return nombreCalles;
	}
	public void setNombreCalles(String nombreCalles) {
		this.nombreCalles = nombreCalles;
	}
	public String getDetalle() {
		return detalle;
	}
	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}
	public int getCodigoPostal() {
		return codigoPostal;
	}
	public void setCodigoPostal(int codigoPostal) {
		this.codigoPostal = codigoPostal;
	}
	public double getMetrosCuadrados() {
		return metrosCuadrados;
	}
	public void setMetrosCuadrados(double metrosCuadrados) {
		this.metrosCuadrados = metrosCuadrados;
	}
	public double getMetrosCuadradosConstruidos() {
		return metrosCuadradosConstruidos;
	}
	public void setMetrosCuadradosConstruidos(double metrosCuadradosConstruidos) {
		this.metrosCuadradosConstruidos = metrosCuadradosConstruidos;
	}
	public int getCuartos() {
		return cuartos;
	}
	public void setCuartos(int cuartos) {
		this.cuartos = cuartos;
	}
	public int getCuartosServicio() {
		return cuartosServicio;
	}
	public void setCuartosServicio(int cuartosServicio) {
		this.cuartosServicio = cuartosServicio;
	}
	public int getAseos() {
		return aseos;
	}
	public void setAseos(int aseos) {
		this.aseos = aseos;
	}
	public int getAseosServicio() {
		return aseosServicio;
	}
	public void setAseosServicio(int aseosServicio) {
		this.aseosServicio = aseosServicio;
	}
	public int getEstacionamiento() {
		return estacionamiento;
	}
	public void setEstacionamiento(int estacionamiento) {
		this.estacionamiento = estacionamiento;
	}
	public boolean isPiscina() {
		return piscina;
	}
	public void setPiscina(boolean piscina) {
		this.piscina = piscina;
	}
	public boolean isCanchaTenis() {
		return canchaTenis;
	}
	public void setCanchaTenis(boolean canchaTenis) {
		this.canchaTenis = canchaTenis;
	}
	public boolean isCanchaBasket() {
		return canchaBasket;
	}
	public void setCanchaBasket(boolean canchaBasket) {
		this.canchaBasket = canchaBasket;
	}
	public boolean isCanchaFutbolSalon() {
		return canchaFutbolSalon;
	}
	public void setCanchaFutbolSalon(boolean canchaFutbolSalon) {
		this.canchaFutbolSalon = canchaFutbolSalon;
	}
	public boolean isParque() {
		return parque;
	}
	public void setParque(boolean parque) {
		this.parque = parque;
	}
	public boolean isJuegosInfantiles() {
		return juegosInfantiles;
	}
	public void setJuegosInfantiles(boolean juegosInfantiles) {
		this.juegosInfantiles = juegosInfantiles;
	}
	public boolean isCanchaMultiusos() {
		return canchaMultiusos;
	}
	public void setCanchaMultiusos(boolean canchaMultiusos) {
		this.canchaMultiusos = canchaMultiusos;
	}
	public boolean isGym() {
		return gym;
	}
	public void setGym(boolean gym) {
		this.gym = gym;
	}
	public int getCalles() {
		return calles;
	}
	public void setCalles(int calles) {
		this.calles = calles;
	}
	public int getAvenidas() {
		return avenidas;
	}
	public void setAvenidas(int avenidas) {
		this.avenidas = avenidas;
	}
	public int getIdEmpleado() {
		return idEmpleado;
	}
	public void setIdEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
	}
	public int getIdPropiedad() {
		return idPropiedad;
	}
	public void setIdPropiedad(int idPropiedad) {
		this.idPropiedad = idPropiedad;
	}
	public int getIdTipoInmueble() {
		return idTipoInmueble;
	}
	public void setIdTipoInmueble(int idTipoInmueble) {
		this.idTipoInmueble = idTipoInmueble;
	}
	private double metrosCuadrados;
	private double metrosCuadradosConstruidos;
	private int cuartos;
	private int cuartosServicio;
	private int aseos;
	private int aseosServicio;
	private int estacionamiento;
	private boolean piscina;
	private boolean canchaTenis;
	private boolean canchaBasket;
	private boolean canchaFutbolSalon;
	private boolean parque;
	private boolean juegosInfantiles;
	private boolean canchaMultiusos;
	private boolean gym;
}
