package com.mycompany.interfaces;

import java.util.List;

import com.mycompany.models.Calles;

public interface DAOCalles {

	public void registrar(Calles calle);
	public void actualizar(Calles calle);
	public void eliminar(Calles calle);
	public Calles buscarPorId(int id);
	public List<Calles> buscarTodos();
}
