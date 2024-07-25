package com.mycompany.interfaces;

import java.util.List;

import com.mycompany.models.Calles;

public interface DAOCalles {

	public void registrar(Calles calle) throws Exception;
	public void actualizar(Calles calle) throws Exception;
	public void eliminar(Calles calle) throws Exception;
	public Calles buscarPorId(int id) throws Exception;
	public List<Calles> buscarTodos() throws Exception;
	public int buscarIdPorNombre(String calle);
}
