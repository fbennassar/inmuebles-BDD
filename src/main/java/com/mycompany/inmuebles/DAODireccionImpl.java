package com.mycompany.inmuebles;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.mycompany.db.Database;
import com.mycompany.interfaces.DAODireccion;
import com.mycompany.models.Direccion;

public class DAODireccionImpl extends Database implements DAODireccion {

	@Override
	public void registrar(Direccion direccion) throws Exception {
		try {
		    this.Conectar();
		    
		    // Verificar si el valor de 'Detalle' ya existe en la tabla Estado
		    String sqlCheck = "SELECT COUNT(*) FROM Direccion WHERE Detalle = ?";
		    PreparedStatement psCheck = this.conexion.prepareStatement(sqlCheck);
		    psCheck.setString(1, direccion.getDetalle());
		    ResultSet rs = psCheck.executeQuery();
		    
		    if (!rs.next() || rs.getInt(1) == 0) {
		        // Si no existe, proceder con la inserción
		    	String sqlInsert = "INSERT INTO Direccion (Detalle, idCalles, idAvenidas, idMunicipio, idEstado, idcodigoPostal) VALUES (?, ?, ?, ?, ?, ?)";
		        PreparedStatement psInsert = this.conexion.prepareStatement(sqlInsert);
		        psInsert.setString(1, direccion.getDetalle());
		        psInsert.setInt(2, direccion.getIdCalle());
		        psInsert.setInt(3, direccion.getIdAvenida());
		        psInsert.setInt(4, direccion.getIdMunicipio());
		        psInsert.setInt(5, direccion.getIdEstado());
		        psInsert.setInt(6, direccion.getIdCodigoPostal());
		        psInsert.executeUpdate();
		    }
		} catch (Exception e) {
		    throw e;
		} finally {
		    this.Cerrar();
		}
		
	}

	@Override
	public void actualizar(Direccion direccion) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(Direccion direccion) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Direccion buscarPorId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Direccion> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int buscarIdPorDetalle(String detalle) throws Exception {
		int id = -1;
	    try {
	        this.Conectar();
	        String sql = "SELECT idDireccion FROM Direccion WHERE Detalle = ?";
	        PreparedStatement ps = this.conexion.prepareStatement(sql);
	        ps.setString(1, detalle);
	        ResultSet rs = ps.executeQuery();
	        
	        if (rs.next()) {
	            id = rs.getInt("idDireccion");
	        }
	    } catch (Exception e) {
	        throw e;
	    } finally {
	        this.Cerrar();
	    }
	    return id;
	}

}
