package com.mycompany.inmuebles;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mycompany.db.Database;
import com.mycompany.interfaces.DAOAvenidas;
import com.mycompany.models.Avenidas;

public class DAOAvenidasImpl extends Database implements DAOAvenidas {
	@Override
	public void registrar(Avenidas avenida) throws Exception{
		
		try {
		    this.Conectar();
		    
		    // Verificar si el valor de 'Avenidas' ya existe
		    String sqlCheck = "SELECT COUNT(*) FROM Avenidas WHERE Avenidas = ?";
		    PreparedStatement psCheck = this.conexion.prepareStatement(sqlCheck);
		    psCheck.setString(1, avenida.getAvenida());
		    ResultSet rs = psCheck.executeQuery();
		    
		    if (rs.next() && rs.getInt(1) > 0) {
		    } else {
		        // Si no existe, proceder con la inserción
		        String sqlInsert = "INSERT INTO Avenidas (Avenidas) VALUES (?)";
		        PreparedStatement psInsert = this.conexion.prepareStatement(sqlInsert);
		        psInsert.setString(1, avenida.getAvenida());
		        psInsert.executeUpdate();
		    }
		} catch (Exception e) {
		    throw e;
		} finally {
		    this.Cerrar();
		}
		
	}

	@Override
	public void actualizar(Avenidas avenida) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(Avenidas avenida) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Avenidas buscarPorId(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Avenidas> buscarTodos() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int buscarIdPorNombre(String avenida) {
		String query = "SELECT idAvenidas FROM Avenidas WHERE Avenidas = ?";
	    try {
	        this.Conectar(); // Asegúrate de que la conexión está abierta
	        try (PreparedStatement stmt = conexion.prepareStatement(query)) {
	            stmt.setString(1, avenida);
	            System.out.println("Executing query: " + stmt.toString());
	            try (ResultSet rs = stmt.executeQuery()) {
	                if (rs.next()) {
	                    int idAvenidas = rs.getInt("idAvenidas");
	                    System.out.println("Found idAvenidas: " + idAvenidas);
	                    return idAvenidas;
	                } else {
	                    System.out.println("No matching record found for avenida: " + avenida);
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
