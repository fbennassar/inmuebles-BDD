package com.mycompany.interfaces;

import java.util.List;

import com.mycompany.models.CodigoPostal;

public interface DAOCodigoPostal {

	public void registrar(CodigoPostal codigoPostal) throws Exception;
	public void actualizar(CodigoPostal codigoPostal) throws Exception;
	public void eliminar(CodigoPostal codigoPostal) throws Exception;
	public CodigoPostal buscarPorId(int id) throws Exception;
	public List<CodigoPostal> buscarTodos() throws Exception;
	public int buscarIdPorCodigo(int int1);
	
}
