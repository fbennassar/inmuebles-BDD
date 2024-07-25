package com.mycompany.inmuebles;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.mycompany.db.Database;
import com.mycompany.interfaces.DAOCodigoPostal;
import com.mycompany.models.CodigoPostal;

public class DAOCodigoPostalImpl extends Database implements DAOCodigoPostal {

	@Override
	public void registrar(CodigoPostal codigoPostal) throws Exception {
		try {
		    this.Conectar();
		    
		    // Verificar si el valor de 'Nombre' ya existe en la tabla Estado
		    String sqlCheck = "SELECT COUNT(*) FROM codigoPostal WHERE codigoPostal = ?";
		    PreparedStatement psCheck = this.conexion.prepareStatement(sqlCheck);
		    psCheck.setInt(1, codigoPostal.getCodigoPostal());
		    ResultSet rs = psCheck.executeQuery();
		    
		    if (!rs.next() || rs.getInt(1) == 0) {
		        // Si no existe, proceder con la inserción
		        String sqlInsert = "INSERT INTO codigoPostal (codigoPostal) VALUES (?)";
		        PreparedStatement psInsert = this.conexion.prepareStatement(sqlInsert);
		        psInsert.setInt(1, codigoPostal.getCodigoPostal());
		        psInsert.executeUpdate();
		    }
		} catch (Exception e) {
		    throw e;
		} finally {
		    this.Cerrar();
		}
		
	}

	@Override
	public void actualizar(CodigoPostal codigoPostal) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(CodigoPostal codigoPostal) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public CodigoPostal buscarPorId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CodigoPostal> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int buscarIdPorCodigo(int codigoPostal) {
		String query = "SELECT idcodigoPostal FROM codigoPostal WHERE codigoPostal = ?";
	    try {
	        this.Conectar(); // Asegúrate de que la conexión está abierta
	        try (PreparedStatement stmt = conexion.prepareStatement(query)) {
	            stmt.setInt(1, codigoPostal);
	            System.out.println("Executing query: " + stmt.toString());
	            try (ResultSet rs = stmt.executeQuery()) {
	                if (rs.next()) {
	                    int idCodigoPostal = rs.getInt("idcodigoPostal");
	                    System.out.println("Found idcodigoPostal: " + idCodigoPostal);
	                    return idCodigoPostal;
	                } else {
	                    System.out.println("No matching record found for codigoPostal: " + codigoPostal);
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
	    return -1; // Retorna -1 si no se encuentra el ID
	}

}
