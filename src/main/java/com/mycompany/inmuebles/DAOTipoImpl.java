package com.mycompany.inmuebles;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mycompany.db.Database;
import com.mycompany.interfaces.DAOTipoInmueble;
import com.mycompany.models.TipoInmueble;

public class DAOTipoImpl extends Database implements DAOTipoInmueble {

	@Override
	public void registrar(TipoInmueble tipoInmueble) throws Exception {
		
		try {
			this.Conectar();
			PreparedStatement ps = this.conexion.prepareStatement("INSERT INTO tipoInmueble (nombreTipo) VALUES (?);");
			ps.setString(1, tipoInmueble.getNombre());
			ps.executeUpdate();
		}
		catch (Exception e) {
			throw e;
		} finally {
			this.Cerrar();
		}
		
	}

	@Override
	public void actualizar(TipoInmueble tipoInmueble) throws Exception {
		
	}

	@Override
	public void eliminar(TipoInmueble tipoInmueble) throws Exception {
		
	}

	@Override
	public TipoInmueble buscarPorId(int id) throws Exception {
		
		return null;
	}

	@Override
	public List<TipoInmueble> buscarTodos() throws Exception {
		
		List<TipoInmueble> tipos = null;
			
			try {
				this.Conectar();
				PreparedStatement ps = this.conexion.prepareStatement("SELECT * FROM tipoInmueble;");
				
				tipos = new ArrayList<TipoInmueble>();
				ResultSet rs = ps.executeQuery();
				
				while(rs.next()) {
	                TipoInmueble tipo = new TipoInmueble();
	                tipo.setId(rs.getInt("idTipoInmueble"));
	                tipo.setNombre(rs.getString("nombreTipo"));
	                
	                tipos.add(tipo);
	            }
				rs.close();
				ps.close();
			} catch (Exception e) {
				throw e;
			} finally {
				this.Cerrar();
			}
			
			return tipos;
		}

	@Override
	public int buscarIdPorNombre(String Nombre) throws Exception {
		 int idTipoInmueble = -1;
		    try {
		        this.Conectar();
		        String sql = "SELECT idTipoInmueble FROM tipoInmueble WHERE nombreTipo = ?";
		        PreparedStatement ps = this.conexion.prepareStatement(sql);
		        ps.setString(1, Nombre);
		        ResultSet rs = ps.executeQuery();
		        
		        if (rs.next()) {
		            idTipoInmueble = rs.getInt("idTipoInmueble");
		        }
		    } catch (Exception e) {
		        throw e;
		    } finally {
		        this.Cerrar();
		    }
		    return idTipoInmueble;
	}
		

}