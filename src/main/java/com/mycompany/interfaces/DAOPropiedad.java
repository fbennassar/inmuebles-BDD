package com.mycompany.interfaces;

import java.util.List;

import com.mycompany.models.Propiedad;

public interface DAOPropiedad {

	public void registrar(Propiedad propiedad);
	public void actualizar(Propiedad propiedad);
	public void eliminar(Propiedad propiedad);
	public Propiedad buscarPorId(int id);
	public List<Propiedad> buscarTodos();
}
