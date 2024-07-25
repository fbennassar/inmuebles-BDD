package com.mycompany.inmuebles;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.mycompany.db.Database;
import com.mycompany.interfaces.DAOPropiedad;
import com.mycompany.models.Propiedad;

public class DAOPropiedadImpl extends Database implements DAOPropiedad{

	@Override
	public void registrar(Propiedad propiedad) throws Exception {
		try {
		    this.Conectar();
		    
		    // Verificar si el valor de 'Detalle' ya existe en la tabla Estado
		    String sqlCheck = "SELECT COUNT(*) FROM propiedad WHERE idDireccion = ?";
		    PreparedStatement psCheck = this.conexion.prepareStatement(sqlCheck);
		    psCheck.setInt(1, propiedad.getIdDireccion());
		    ResultSet rs = psCheck.executeQuery();
		    
		    if (!rs.next() || rs.getInt(1) == 0) {
		        // Si no existe, proceder con la inserción
		    	String sqlInsert = "INSERT INTO propiedad (metrosCuadrados, metrosCuadradosConstruidos, construida, "
		    			+ "estacionamiento, aseos, aseosServicio, cuartos, cuartosServicio, "
		    			+ "idDireccion, piscina, canchaTenis, canchaBasket, canchaFutbolSalon, "
		    			+ "Parque, JuegosInfantiles, canchaMultiusos, gym) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		        PreparedStatement psInsert = this.conexion.prepareStatement(sqlInsert);
		        psInsert.setDouble(1, propiedad.getMetrosCuadrados());
		        psInsert.setDouble(2, propiedad.getMetrosCuadradosConstruidos());
		        psInsert.setDate(3, propiedad.getFechaConstruccion());
		        psInsert.setInt(4, propiedad.getEstacionamiento());
		        psInsert.setInt(5, propiedad.getAseos());
		        psInsert.setInt(6, propiedad.getAseosServicio());
		        psInsert.setInt(7, propiedad.getCuartos());
		        psInsert.setInt(8, propiedad.getCuartosServicio());
		        psInsert.setInt(9, propiedad.getIdDireccion());
		        psInsert.setBoolean(10, propiedad.isPiscina());
		        psInsert.setBoolean(11, propiedad.isCanchaTenis());
		        psInsert.setBoolean(12, propiedad.isCanchaBasket());
		        psInsert.setBoolean(13, propiedad.isCanchaFutbolSalon());
		        psInsert.setBoolean(14, propiedad.isParque());
		        psInsert.setBoolean(15, propiedad.isJuegosInfantiles());
		        psInsert.setBoolean(16, propiedad.isCanchaMultiusos());
		        psInsert.setBoolean(17, propiedad.isGimnasio());
		        psInsert.executeUpdate();
		    }
		} catch (Exception e) {
		    throw e;
		} finally {
		    this.Cerrar();
		}
		
	}

	@Override
	public void actualizar(Propiedad propiedad) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(Propiedad propiedad) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Propiedad buscarPorId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Propiedad> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int buscarIdPorIdDireccion(int idDireccion) throws Exception {
		 int idPropiedad = -1;
		    try {
		        this.Conectar();
		        String sql = "SELECT idPropiedad FROM propiedad WHERE idDireccion = ?";
		        PreparedStatement ps = this.conexion.prepareStatement(sql);
		        ps.setInt(1, idDireccion);
		        ResultSet rs = ps.executeQuery();
		        
		        if (rs.next()) {
		            idPropiedad = rs.getInt("idPropiedad");
		        }
		    } catch (Exception e) {
		        throw e;
		    } finally {
		        this.Cerrar();
		    }
		    return idPropiedad;
	}

}
