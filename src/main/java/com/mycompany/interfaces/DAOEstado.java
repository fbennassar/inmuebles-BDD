package com.mycompany.interfaces;

import java.util.List;

import com.mycompany.models.Estado;

public interface DAOEstado {

	public void registrar(Estado estado);
	public void actualizar(Estado estado);
	public void eliminar(Estado estado);
	public Estado buscarPorId(int id);
	public List<Estado> buscarTodos();
}
