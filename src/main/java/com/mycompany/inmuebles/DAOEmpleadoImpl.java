package com.mycompany.inmuebles;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mycompany.db.Database;
import com.mycompany.interfaces.DAOEmpleado;
import com.mycompany.models.Empleado;

public class DAOEmpleadoImpl extends Database implements DAOEmpleado {

	@Override
	public void registrar(Empleado empleado) throws Exception {
		
		try {
			this.Conectar();
			PreparedStatement ps = this.conexion.prepareStatement("INSERT INTO empleado (nombre, telefono, email, cedula) VALUES (?, ?, ?, ?);");
			ps.setString(1, empleado.getNombre());
			ps.setString(2, empleado.getTelefono());
			ps.setString(3, empleado.getEmail());
			ps.setInt(4, empleado.getCedula());
			ps.executeUpdate();
		}
		catch (Exception e) {
			throw e;
		} finally {
			this.Cerrar();
		}
		
	}

	@Override
	public void actualizar(Empleado empleado) throws Exception {

		try {
			this.Conectar();
			PreparedStatement ps = this.conexion.prepareStatement(
					"UPDATE empleado SET nombre = ?, telefono = ?, email = ?, cedula = ? WHERE idEmpleado = ?;");
			ps.setString(1, empleado.getNombre());
			ps.setString(2, empleado.getTelefono());
			ps.setString(3, empleado.getEmail());
			ps.setInt(4, empleado.getCedula());
			ps.setInt(5, empleado.getId());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.Cerrar();
		}
		
	}

	@Override
	public void eliminar(int idEmpleado) throws Exception {
		
		try {
			this.Conectar();
			PreparedStatement ps = this.conexion.prepareStatement("DELETE FROM empleado WHERE idEmpleado = ?;");
			ps.setInt(1, idEmpleado);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.Cerrar();
		}
		
	}

	@Override
	public Empleado buscarPorCedula(int cedula) throws Exception {
		
		Empleado empleado = new Empleado();
		try {
			this.Conectar();
			PreparedStatement ps = this.conexion.prepareStatement("SELECT * FROM empleado WHERE cedula = ?;");
			ps.setInt(1, cedula);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				empleado.setId(rs.getInt("idEmpleado"));
				empleado.setNombre(rs.getString("nombre"));
				empleado.setTelefono(rs.getString("telefono"));
				empleado.setEmail(rs.getString("email"));
				empleado.setCedula(rs.getInt("cedula"));
			}
		} catch (Exception e) {
			throw e;
		} finally {
			this.Cerrar();
		}
		return empleado;
	}
	
	@Override
	public List<Empleado> buscarPorNombre(String nombre) throws Exception {
		List<Empleado> empleados = null;
		
		try {
			this.Conectar();
			String query = nombre.isEmpty() ? "SELECT * FROM empleado;" : "SELECT * FROM empleado WHERE nombre LIKE '%" + nombre + "%';";
			PreparedStatement ps = this.conexion.prepareStatement(query);
			
			empleados = new ArrayList<Empleado>();
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
                Empleado empleado = new Empleado();
                empleado.setId(rs.getInt("idEmpleado"));
                empleado.setNombre(rs.getString("nombre"));
                empleado.setTelefono(rs.getString("telefono"));
                empleado.setEmail(rs.getString("email"));
                empleado.setCedula(rs.getInt("cedula"));
                
                empleados.add(empleado);
            }
			rs.close();
			ps.close();
		} catch (Exception e) {
			throw e;
		} finally {
			this.Cerrar();
		}
		return empleados;
	}

	@Override
	public List<Empleado> buscarTodos() throws Exception{
		List<Empleado> empleados = null;
		
		try {
			this.Conectar();
			PreparedStatement ps = this.conexion.prepareStatement("SELECT * FROM empleado;");
			
			empleados = new ArrayList<Empleado>();
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
                Empleado empleado = new Empleado();
                empleado.setId(rs.getInt("idEmpleado"));
                empleado.setNombre(rs.getString("nombre"));
                empleado.setTelefono(rs.getString("telefono"));
                empleado.setEmail(rs.getString("email"));
                empleado.setCedula(rs.getInt("cedula"));
                
                empleados.add(empleado);
            }
			rs.close();
			ps.close();
		} catch (Exception e) {
			throw e;
		} finally {
			this.Cerrar();
		}
		
		return empleados;
	}

	@Override
	public Empleado buscarPorId(int idEmpleado) throws Exception {
		Empleado empleado = new Empleado();
		
		try {
			this.Conectar();
			PreparedStatement ps = this.conexion.prepareStatement("SELECT * FROM empleado WHERE idEmpleado = ?;");
			ps.setInt(1, idEmpleado);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				empleado.setId(rs.getInt("idEmpleado"));
				empleado.setNombre(rs.getString("nombre"));
				empleado.setTelefono(rs.getString("telefono"));
				empleado.setEmail(rs.getString("email"));
				empleado.setCedula(rs.getInt("cedula"));
			}
			rs.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.Cerrar();
		}
		return empleado;
	}
	
	@Override
	public int buscarIdPorNombre(String Nombre) throws Exception {
		int idEmpleado = -1;
	    try {
	        this.Conectar();
	        String sql = "SELECT idEmpleado FROM empleado WHERE nombre = ?";
	        PreparedStatement ps = this.conexion.prepareStatement(sql);
	        ps.setString(1, Nombre);
	        ResultSet rs = ps.executeQuery();
	        
	        if (rs.next()) {
	            idEmpleado = rs.getInt("idEmpleado");
	        }
	    } catch (Exception e) {
	        throw e;
	    } finally {
	        this.Cerrar();
	    }
	    return idEmpleado;
	}



}
