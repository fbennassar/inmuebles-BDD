package com.mycompany.interfaces;

import java.util.List;

import com.mycompany.models.Publicacion;

public interface DAOPublicacion {

	public void registrar(Publicacion publicacion);
	public void actualizar(Publicacion publicacion);
	public void eliminar(Publicacion publicacion);
	public Publicacion buscarPorId(int id);
	public List<Publicacion> buscarTodos();
}
