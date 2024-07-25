package com.mycompany.interfaces;

import java.util.List;

import com.mycompany.models.Empleado;

public interface DAOEmpleado {

	public void registrar(Empleado empleado) throws Exception;
	public void actualizar(Empleado empleado) throws Exception;
	public void eliminar(int idEmpleado) throws Exception;
	public Empleado buscarPorCedula(int cedula)throws Exception;
	public List<Empleado> buscarPorNombre(String nombre)throws Exception;
	public List<Empleado> buscarTodos() throws Exception;
	public Empleado buscarPorId(int idEmpleado) throws Exception;
	public int buscarIdPorNombre(String string) throws Exception;
}
