package com.mycompany.interfaces;

import java.util.List;

import com.mycompany.models.Direccion;

public interface DAODireccion {

	public void registrar(Direccion direccion) throws Exception;
	public void actualizar(Direccion direccion) throws Exception;
	public void eliminar(Direccion direccion) throws Exception;
	public Direccion buscarPorId(int id) throws Exception;
    public List<Direccion> buscarTodos() throws Exception;
	public int buscarIdPorDetalle(String detalle) throws Exception;
}
