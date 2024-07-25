package com.mycompany.interfaces;

import java.util.List;

import com.mycompany.models.Estado;

public interface DAOEstado {

	public void registrar(Estado estado) throws Exception;
	public void actualizar(Estado estado) throws Exception;
	public void eliminar(Estado estado) throws Exception;
	public Estado buscarPorId(int id) throws Exception;
	public List<Estado> buscarTodos() throws Exception;
	public int buscarIdPorNombre(String estado);
}
