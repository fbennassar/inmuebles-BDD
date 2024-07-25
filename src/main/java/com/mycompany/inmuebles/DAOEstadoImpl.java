package com.mycompany.inmuebles;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.mycompany.db.Database;
import com.mycompany.interfaces.DAOEstado;
import com.mycompany.models.Estado;

public class DAOEstadoImpl extends Database implements DAOEstado {

	@Override
	public void registrar(Estado estado) throws Exception {
		
		try {
		    this.Conectar();
		    
		    // Verificar si el valor de 'Nombre' ya existe en la tabla Estado
		    String sqlCheck = "SELECT COUNT(*) FROM estado WHERE Nombre = ?";
		    PreparedStatement psCheck = this.conexion.prepareStatement(sqlCheck);
		    psCheck.setString(1, estado.getNombre());
		    ResultSet rs = psCheck.executeQuery();
		    
		    if (!rs.next() || rs.getInt(1) == 0) {
		        // Si no existe, proceder con la inserción
		        String sqlInsert = "INSERT INTO estado (Nombre) VALUES (?)";
		        PreparedStatement psInsert = this.conexion.prepareStatement(sqlInsert);
		        psInsert.setString(1, estado.getNombre());
		        psInsert.executeUpdate();
		    }
		} catch (Exception e) {
		    throw e;
		} finally {
		    this.Cerrar();
		}
		
	}

	@Override
	public void actualizar(Estado estado) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(Estado estado) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Estado buscarPorId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Estado> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int buscarIdPorNombre(String estado) {
		 String query = "SELECT idEstado FROM estado WHERE Nombre = ?";
		    try {
		        this.Conectar(); // Asegúrate de que la conexión está abierta
		        try (PreparedStatement stmt = conexion.prepareStatement(query)) {
		            stmt.setString(1, estado);
		            System.out.println("Executing query: " + stmt.toString());
		            try (ResultSet rs = stmt.executeQuery()) {
		                if (rs.next()) {
		                    int idEstado = rs.getInt("idEstado");
		                    System.out.println("Found idEstado: " + idEstado);
		                    return idEstado;
		                } else {
		                    System.out.println("No matching record found for estado: " + estado);
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
