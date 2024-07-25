package com.mycompany.inmuebles;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
			ps.close();
		}
		catch (Exception e) {
			throw e;
		} finally {
			this.Cerrar();
		}
		
	}

	@Override
	public void actualizar(Cliente cliente) throws Exception {
		try {
			this.Conectar();
			PreparedStatement ps = this.conexion.prepareStatement(
					"UPDATE cliente SET nombre = ?, telefono = ?, email = ?, cedula = ? WHERE id = ?;");
			ps.setString(1, cliente.getNombre());
			ps.setString(2, cliente.getTelefono());
			ps.setString(3, cliente.getEmail());
			ps.setInt(4, cliente.getCedula());
			ps.setInt(5, cliente.getId());
			ps.executeUpdate();
		} 
		catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.Cerrar();
		}
		
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

	@Override
	public Cliente buscarPorCedula(int cedula) throws Exception {
		Cliente cliente = null;
		try {
			this.Conectar();
			PreparedStatement ps = this.conexion.prepareStatement("SELECT * FROM cliente WHERE cedula = ?;");
			ps.setInt(1, cedula);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				cliente = new Cliente();
                cliente.setId(rs.getInt("idCliente"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setTelefono(rs.getString("telefono"));
                cliente.setEmail(rs.getString("email"));
                cliente.setCedula(rs.getInt("cedula"));

			}
			ps.close();
			rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				this.Cerrar();
			}
		
		return cliente;
	}
	
	@Override
	public int buscarIdPorCedula(int cedula) throws Exception {
		int idCliente = -1;
	    try {
	        this.Conectar();
	        String sql = "SELECT idCliente FROM cliente WHERE cedula = ?";
	        PreparedStatement ps = this.conexion.prepareStatement(sql);
	        ps.setInt(1, cedula);
	        ResultSet rs = ps.executeQuery();
	        
	        if (rs.next()) {
	            idCliente = rs.getInt("idCliente");
	        }
	    } catch (Exception e) {
	        throw e;
	    } finally {
	        this.Cerrar();
	    }
	    return idCliente;
	}

}
