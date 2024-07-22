package com.mycompany.interfaces;

import java.util.List;

import com.mycompany.models.Empleado;

public interface DAOEmpleado {

	public void registrar(Empleado empleado) throws Exception;
	public void actualizar(Empleado empleado);
	public void eliminar(int idEmpleado) throws Exception;
	public Empleado buscarPorCedula(int cedula)throws Exception;
	public List<Empleado> buscarTodos() throws Exception;
}
