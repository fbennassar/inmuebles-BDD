package com.mycompany.interfaces;

import java.util.List;

import com.mycompany.models.TipoInmueble;

public interface DAOTipoInmueble {

	public void registrar(TipoInmueble tipoInmueble) throws Exception;
	public void actualizar(TipoInmueble tipoInmueble) throws Exception;
	public void eliminar(TipoInmueble tipoInmueble) throws Exception;
	public TipoInmueble buscarPorId(int id) throws Exception;
	public List<TipoInmueble> buscarTodos() throws Exception;
	public int buscarIdPorNombre(String string) throws Exception;
}
