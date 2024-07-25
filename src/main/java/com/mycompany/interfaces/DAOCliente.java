package com.mycompany.interfaces;

import java.util.List;

import com.mycompany.models.Cliente;

public interface DAOCliente {

	public void registrar(Cliente cliente) throws Exception;
	public void actualizar(Cliente cliente) throws Exception;
	public void eliminar(Cliente cliente) throws Exception;
	public Cliente buscarPorId(int id) throws Exception;
	public Cliente buscarPorCedula(int cedula) throws Exception;
	public List<Cliente> buscarTodos() throws Exception;
	public int buscarIdPorCedula(int int1) throws Exception;
	
}
