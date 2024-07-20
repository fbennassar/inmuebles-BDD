package com.mycompany.interfaces;

import java.util.List;

import com.mycompany.models.Venta;

public interface DAOVenta {

	public void registrar(Venta venta);
	public void actualizar(Venta venta);
	//public void eliminar(Venta venta);
	public Venta buscarPorId(int id);
	public List<Venta> buscarTodos();
}
