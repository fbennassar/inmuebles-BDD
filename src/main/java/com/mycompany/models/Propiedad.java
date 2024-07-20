package com.mycompany.models;

import java.sql.Date;

public class Propiedad {

	private int id;
	private Double metrosCuadrados;
	private Double metrosCuadradosConstruidos;
	private Date fechaConstruccion;
	private int estacionamiento;
	private int aseos;
	private int aseosServicio;
	private int cuartos;
	private int cuartosServicio;
	private int idDireccion;
	private boolean piscina;
	private boolean canchaTenis;
	private boolean canchaBasket;
	private boolean canchaFutbolSalon;
	private boolean parque;
	private boolean juegosInfantiles;
	private boolean canchaMultiusos;
	private boolean gimnasio;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Double getMetrosCuadrados() {
		return metrosCuadrados;
	}
	public void setMetrosCuadrados(Double metrosCuadrados) {
		this.metrosCuadrados = metrosCuadrados;
	}
	public Double getMetrosCuadradosConstruidos() {
		return metrosCuadradosConstruidos;
	}
	public void setMetrosCuadradosConstruidos(Double metrosCuadradosConstruidos) {
		this.metrosCuadradosConstruidos = metrosCuadradosConstruidos;
	}
	public Date getFechaConstruccion() {
		return fechaConstruccion;
	}
	public void setFechaConstruccion(Date fechaConstruccion) {
		this.fechaConstruccion = fechaConstruccion;
	}
	public int getEstacionamiento() {
		return estacionamiento;
	}
	public void setEstacionamiento(int estacionamiento) {
		this.estacionamiento = estacionamiento;
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
	public int getIdDireccion() {
		return idDireccion;
	}
	public void setIdDireccion(int idDireccion) {
		this.idDireccion = idDireccion;
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
	public boolean isGimnasio() {
		return gimnasio;
	}
	public void setGimnasio(boolean gimnasio) {
		this.gimnasio = gimnasio;
	}
	
	
}
