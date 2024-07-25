package com.mycompany.interfaces;

import java.util.List;

import com.mycompany.models.DetallesInmueble;

public interface DAODetallesinmueble {

	public DetallesInmueble buscarPorId(int idPublicacion) throws Exception;
	public void comprar(int idPublicacion) throws Exception;
}
