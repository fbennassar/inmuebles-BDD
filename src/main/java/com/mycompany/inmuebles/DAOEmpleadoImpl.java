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
	public void actualizar(Empleado empleado) {
		// TODO Auto-generated method stub
		
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
		// TODO Auto-generated method stub
		return null;
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

}
