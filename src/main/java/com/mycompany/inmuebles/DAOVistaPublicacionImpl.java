package com.mycompany.inmuebles;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mycompany.db.Database;
import com.mycompany.interfaces.DAOVistaPublicacion;
import com.mycompany.models.Publicacion;
import com.mycompany.models.VistaPublicacion;

public class DAOVistaPublicacionImpl extends Database implements DAOVistaPublicacion{

	@Override
	public List<VistaPublicacion> buscarTodos() throws Exception {
		List<VistaPublicacion> publicaciones = null;
		
		try {
			this.Conectar();
			
			PreparedStatement ps = this.conexion.prepareStatement("SELECT\r\n"
					+ "    idPublicacion,\r\n"
					+ "    disponible,\r\n"
					+ "    tipoinmueble.nombreTipo,\r\n"
					+ "    precio,\r\n"
					+ "    estado.Nombre,\r\n"
					+ "    municipio.Nombre,\r\n"
					+ "    propiedad.cuartos,\r\n"
					+ "    propiedad.aseos,\r\n"
					+ "    propiedad.estacionamiento,\r\n"
					+ "    propiedad.piscina,\r\n"
					+ "    propiedad.canchaTenis,\r\n"
					+ "    propiedad.canchaBasket,\r\n"
					+ "    propiedad.canchaFutbolSalon,\r\n"
					+ "    propiedad.Parque,\r\n"
					+ "    propiedad.juegosInfantiles,\r\n"
					+ "    propiedad.canchaMultiusos,\r\n"
					+ "    propiedad.gym\r\n"
					+ "FROM\r\n"
					+ "    publicacion\r\n"
					+ "JOIN tipoinmueble ON publicacion.idTipoInmueble = tipoinmueble.idTipoInmueble\r\n"
					+ "JOIN propiedad ON publicacion.idPropiedad = propiedad.idPropiedad\r\n"
					+ "JOIN direccion ON propiedad.idDireccion = direccion.idDireccion\r\n"
					+ "JOIN estado ON direccion.idEstado = estado.idEstado\r\n"
					+ "JOIN municipio ON direccion.idMunicipio = municipio.idMunicipio;");
			
			
			publicaciones = new ArrayList<VistaPublicacion>();
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				VistaPublicacion vistaPublicacion = new VistaPublicacion();
				vistaPublicacion.setIdPublicacion(rs.getInt("idPublicacion"));
				vistaPublicacion.setDisponible(rs.getBoolean("disponible"));
				vistaPublicacion.setNombreTipo(rs.getString("nombreTipo"));
				vistaPublicacion.setPrecio(rs.getDouble("precio"));
				vistaPublicacion.setNombreEstado(rs.getString("Nombre"));
				vistaPublicacion.setNombreMunicipio(rs.getString("municipio.Nombre"));
				vistaPublicacion.setCuartos(rs.getInt("cuartos"));
				vistaPublicacion.setAseos(rs.getInt("aseos"));
				vistaPublicacion.setEstacionamiento(rs.getInt("estacionamiento"));
				vistaPublicacion.setPiscina(rs.getBoolean("piscina"));
				
				if (rs.getBoolean("canchaTenis") || rs.getBoolean("canchaBasket") || rs.getBoolean("canchaFutbolSalon") || rs.getBoolean("Parque") || rs.getBoolean("juegosInfantiles") || rs.getBoolean("canchaMultiusos") || rs.getBoolean("gym")) {
					vistaPublicacion.setAreaDeportiva(true);
				} else {
					vistaPublicacion.setAreaDeportiva(false);
				}
				
				publicaciones.add(vistaPublicacion);
			}
			rs.close();
			ps.close();
			
		} catch (Exception e) {
			throw e;
		} finally {
			this.Cerrar();
		}
		return publicaciones;
	}
	
	
	}
