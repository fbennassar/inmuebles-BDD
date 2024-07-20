package com.mycompany.interfaces;

import java.util.List;

import com.mycompany.models.Cliente;

public interface DAOCliente {

	public void registrar(Cliente cliente) throws Exception;
	public void actualizar(Cliente cliente);
	public void eliminar(Cliente cliente);
	public Cliente buscarPorId(int id);
	public List<Cliente> buscarTodos();
}
