package com.mycompany.inmuebles;

import java.util.List;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mycompany.db.Database;
import com.mycompany.interfaces.DAOCalles;
import com.mycompany.models.Calles;

public class DAOCallesImpl extends Database implements DAOCalles {

	@Override
	public void registrar(Calles calle) throws Exception {
		try {
		    this.Conectar();
		    
		    // Verificar si el valor de 'Calles' ya existe
		    String sqlCheck = "SELECT COUNT(*) FROM calles WHERE Calles = ?";
		    PreparedStatement psCheck = this.conexion.prepareStatement(sqlCheck);
		    psCheck.setString(1, calle.getCalle());
		    ResultSet rs = psCheck.executeQuery();
		    
		    if (rs.next() && rs.getInt(1) > 0) {
		    } else {
		        // Si no existe, proceder con la inserción
		        String sqlInsert = "INSERT INTO calles (Calles) VALUES (?)";
		        PreparedStatement psInsert = this.conexion.prepareStatement(sqlInsert);
		        psInsert.setString(1, calle.getCalle());
		        psInsert.executeUpdate();
		    }
		} catch (Exception e) {
		    throw e;
		} finally {
		    this.Cerrar();
		}
		
	}

	@Override
	public void actualizar(Calles calle) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(Calles calle) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Calles buscarPorId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Calles> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int buscarIdPorNombre(String calle) {
		String query = "SELECT idCalles FROM calles WHERE Calles = ?";
        try {
            this.Conectar(); // Asegúrate de que la conexión está abierta
            try (PreparedStatement stmt = conexion.prepareStatement(query)) {
                stmt.setString(1, calle);
                System.out.println("Executing query: " + stmt.toString());
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        int idCalles = rs.getInt("idCalles");
                        System.out.println("Found idCalles: " + idCalles);
                        return idCalles;
                    } else {
                        System.out.println("No matching record found for calle: " + calle);
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
