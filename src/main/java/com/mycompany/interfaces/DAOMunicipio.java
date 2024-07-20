package com.mycompany.interfaces;

import java.util.List;

import com.mycompany.models.Municipio;

public interface DAOMunicipio {

	public void registrar(Municipio municipio);
	public void actualizar(Municipio municipio);
	public void eliminar(Municipio municipio);
	public Municipio buscarPorId(int id);
	public List<Municipio> buscarTodos();
}
