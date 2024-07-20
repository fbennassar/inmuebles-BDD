package com.mycompany.interfaces;

import java.util.List;

import com.mycompany.models.Direccion;

public interface DAODireccion {

	public void registrar(Direccion direccion);
	public void actualizar(Direccion direccion);
	public void eliminar(Direccion direccion);
	public Direccion buscarPorId(int id);
    public List<Direccion> buscarTodos();
}
