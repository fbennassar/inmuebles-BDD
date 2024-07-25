package com.mycompany.interfaces;

import java.util.List;

import com.mycompany.models.Municipio;

public interface DAOMunicipio {

	public void registrar(Municipio municipio) throws Exception;
	public void actualizar(Municipio municipio) throws Exception;
	public void eliminar(Municipio municipio) throws Exception;
	public Municipio buscarPorId(int id) throws Exception;
	public List<Municipio> buscarTodos() throws Exception;
	public int buscarIdPorNombre(String municipio);
}