package com.mycompany.interfaces;

import java.util.List;

import com.mycompany.models.TipoInmueble;

public interface DAOTipoInmueble {

	public void registrar(TipoInmueble tipoInmueble);
	public void actualizar(TipoInmueble tipoInmueble);
	public void eliminar(TipoInmueble tipoInmueble);
	public TipoInmueble buscarPorId(int id);
	public List<TipoInmueble> buscarTodos();
}
