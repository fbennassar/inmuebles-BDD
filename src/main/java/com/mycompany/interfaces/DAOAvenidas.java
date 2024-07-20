package com.mycompany.interfaces;

import java.util.List;

import com.mycompany.models.Avenidas;

public interface DAOAvenidas {

	public void registrar(Avenidas avenida);
	public void actualizar(Avenidas avenida);
	public void eliminar(Avenidas avenida);
	public Avenidas buscarPorId(int id);
	public List<Avenidas> buscarTodos();
}
