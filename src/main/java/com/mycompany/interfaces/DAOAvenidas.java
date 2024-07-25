package com.mycompany.interfaces;

import java.util.List;

import com.mycompany.models.Avenidas;

public interface DAOAvenidas {

	public void registrar(Avenidas avenida) throws Exception;
	public void actualizar(Avenidas avenida) throws Exception;
	public void eliminar(Avenidas avenida) throws Exception;
	public Avenidas buscarPorId(int id) throws Exception;
	public List<Avenidas> buscarTodos() throws Exception;
	public int buscarIdPorNombre(String avenida);
}