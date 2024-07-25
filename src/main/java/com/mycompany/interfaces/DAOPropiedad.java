package com.mycompany.interfaces;

import java.util.List;

import com.mycompany.models.Propiedad;

public interface DAOPropiedad {

	public void registrar(Propiedad propiedad) throws Exception;
	public void actualizar(Propiedad propiedad) throws Exception;
	public void eliminar(Propiedad propiedad) throws Exception;
	public Propiedad buscarPorId(int id) throws Exception;
	public List<Propiedad> buscarTodos() throws Exception;
	public int buscarIdPorIdDireccion(int idDireccion) throws Exception;
}
