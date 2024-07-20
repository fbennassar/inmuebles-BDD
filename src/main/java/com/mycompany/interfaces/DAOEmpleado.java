package com.mycompany.interfaces;

import java.util.List;

import com.mycompany.models.Empleado;

public interface DAOEmpleado {

	public void registrar(Empleado empleado);
	public void actualizar(Empleado empleado);
	public void eliminar(Empleado empleado);
	public Empleado buscarPorId(int id);
	public List<Empleado> buscarTodos();
}
