package com.mycompany.inmuebles;

import java.sql.PreparedStatement;
import java.util.List;

import com.mycompany.db.Database;
import com.mycompany.interfaces.DAOCliente;
import com.mycompany.models.Cliente;

public class DAOClienteImpl extends Database implements DAOCliente {

	@Override
	public void registrar(Cliente cliente) throws Exception {

		try {
			this.Conectar();
			PreparedStatement ps = this.conexion.prepareStatement("INSERT INTO cliente (nombre, telefono, email, cedula) VALUES (?, ?, ?, ?);");
			ps.setString(1, cliente.getNombre());
			ps.setString(2, cliente.getTelefono());
			ps.setString(3, cliente.getEmail());
			ps.setInt(4, cliente.getCedula());
			ps.executeUpdate();
		}
		catch (Exception e) {
			throw e;
		} finally {
			this.Cerrar();
		}
		
	}

	@Override
	public void actualizar(Cliente cliente) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(Cliente cliente) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Cliente buscarPorId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cliente> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

}
