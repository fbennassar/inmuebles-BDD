package com.mycompany.inmuebles;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.mycompany.db.Database;
import com.mycompany.interfaces.DAOMunicipio;
import com.mycompany.models.Municipio;

public class DAOMunicipioImpl extends Database implements DAOMunicipio {

	@Override
	public void registrar(Municipio municipio) throws Exception {
		try {
		    this.Conectar();
		    
		    // Verificar si el valor de 'Nombre' ya existe en la tabla Estado
		    String sqlCheck = "SELECT COUNT(*) FROM municipio WHERE Nombre = ?";
		    PreparedStatement psCheck = this.conexion.prepareStatement(sqlCheck);
		    psCheck.setString(1, municipio.getNombre());
		    ResultSet rs = psCheck.executeQuery();
		    
		    if (!rs.next() || rs.getInt(1) == 0) {
		        // Si no existe, proceder con la inserción
		        String sqlInsert = "INSERT INTO municipio (Nombre) VALUES (?)";
		        PreparedStatement psInsert = this.conexion.prepareStatement(sqlInsert);
		        psInsert.setString(1, municipio.getNombre());
		        psInsert.executeUpdate();
		    }
		} catch (Exception e) {
		    throw e;
		} finally {
		    this.Cerrar();
		}
		
	}

	@Override
	public void actualizar(Municipio municipio) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(Municipio municipio) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Municipio buscarPorId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Municipio> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int buscarIdPorNombre(String municipio) {
		String query = "SELECT idMunicipio FROM municipio WHERE Nombre = ?";
	    try {
	        this.Conectar(); // Asegúrate de que la conexión está abierta
	        try (PreparedStatement stmt = conexion.prepareStatement(query)) {
	            stmt.setString(1, municipio);
	            System.out.println("Executing query: " + stmt.toString());
	            try (ResultSet rs = stmt.executeQuery()) {
	                if (rs.next()) {
	                    int idMunicipio = rs.getInt("idMunicipio");
	                    System.out.println("Found idMunicipio: " + idMunicipio);
	                    return idMunicipio;
	                } else {
	                    System.out.println("No matching record found for municipio: " + municipio);
	                }
	            }
	        }
	    } catch (SQLException | ClassNotFoundException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            this.Cerrar(); // Cierra la conexión después de usarla
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    return -1;
	}

}
