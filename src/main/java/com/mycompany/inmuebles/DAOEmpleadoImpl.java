package com.mycompany.inmuebles;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mycompany.db.Database;
import com.mycompany.interfaces.DAOEmpleado;
import com.mycompany.models.Empleado;

public class DAOEmpleadoImpl extends Database implements DAOEmpleado {

	@Override
	public void registrar(Empleado empleado) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actualizar(Empleado empleado) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(Empleado empleado) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Empleado buscarPorId(int id) {
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
