package com.mycompany.inmuebles;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mycompany.db.Database;
import com.mycompany.interfaces.DAOPublicacion;
import com.mycompany.models.Publicacion;

public class DAOPublicacionImpl extends Database implements DAOPublicacion {

	@Override
	public void registrar(Publicacion publicacion) throws Exception {
		try {
			this.Conectar();
			PreparedStatement ps = this.conexion.prepareStatement("INSERT INTO publicacion (fechaPublicacion, idCliente, precio, "
					+ "descripcion, idPropiedad, idEmpleado, "
					+ "idTipoInmueble, disponible) VALUES (?, ?, ?, ?, ?, ?, ?, ?);");
			ps.setDate(1, publicacion.getFecha());
			ps.setInt(2, publicacion.getIdCliente());
			ps.setDouble(3, publicacion.getPrecio());
			ps.setString(4, publicacion.getDescripcion());
			ps.setInt(5, publicacion.getIdPropiedad());
			ps.setInt(6, publicacion.getIdEmpleado());
			ps.setInt(7, publicacion.getIdTipoInmueble());
			ps.setBoolean(8, publicacion.isDisponible());
			ps.executeUpdate();
		}
		catch (Exception e) {
			throw e;
		} finally {
			this.Cerrar();
		}
		
	}

	@Override
	public void actualizar(Publicacion publicacion) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(Publicacion publicacion) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Publicacion buscarPorId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Publicacion> buscarTodos() {
		List<Publicacion> publicaciones = null;
		
		try {
			this.Conectar();
			
			PreparedStatement ps = this.conexion.prepareStatement("SELECT\r\n"
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
			
			
			publicaciones = new ArrayList<Publicacion>();
			ResultSet rs = ps.executeQuery();
		} catch (Exception e) {
			
		}
		return null;
	}

}
