package com.mycompany.interfaces;

import java.util.List;

import com.mycompany.models.CodigoPostal;

public interface DAOCodigoPostal {

	public void registrar(CodigoPostal codigoPostal);
	public void actualizar(CodigoPostal codigoPostal);
	public void eliminar(CodigoPostal codigoPostal);
	public CodigoPostal buscarPorId(int id);
	public List<CodigoPostal> buscarTodos();
	
}
