package com.mycompany.inmuebles;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.mycompany.db.Database;
import com.mycompany.interfaces.DAODetallesinmueble;
import com.mycompany.models.DetallesInmueble;

public class DAODetallesinmuebleImpl extends Database implements DAODetallesinmueble{

	@Override
	public DetallesInmueble buscarPorId(int idPublicacion) throws Exception {
		
		DetallesInmueble detallesInmueble = new DetallesInmueble();
		
		try {
			this.Conectar();
			PreparedStatement ps = this.conexion.prepareStatement("SELECT\r\n"
					+ "    idPublicacion,\r\n"
					+ "    cliente.nombre,\r\n"
					+ "    empleado.idEmpleado,\r\n"
					+ "    empleado.nombre,\r\n"
					+ "    empleado.telefono,\r\n"
					+ "    fechaPublicacion,\r\n"
					+ "    tipoInmueble.idTipoInmueble,\r\n"
					+ "    tipoinmueble.nombreTipo,\r\n"
					+ "    precio,\r\n"
					+ "    descripcion,\r\n"
					+ "    estado.Nombre,\r\n"
					+ "    municipio.Nombre,\r\n"
					+ "    avenidas.Nombre,\r\n"
					+ "    avenidas.Avenidas,\r\n"
					+ "    calles.Nombre,\r\n"
					+ "    calles.Calles,\r\n"
					+ "    direccion.Detalle,\r\n"
					+ "    codigopostal.codigoPostal,\r\n"
					+ "    propiedad.idPropiedad,\r\n"
					+ "    propiedad.metrosCuadrados,\r\n"
					+ "    propiedad.metrosCuadradosConstruidos,\r\n"
					+ "    propiedad.cuartos,\r\n"
					+ "    propiedad.cuartosServicio,\r\n"
					+ "    propiedad.aseos,\r\n"
					+ "    propiedad.aseosServicio,\r\n"
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
					+ "JOIN cliente ON cliente.idCliente = publicacion.idCliente\r\n"
					+ "JOIN empleado ON empleado.idEmpleado = publicacion.idEmpleado\r\n"
					+ "JOIN tipoinmueble ON publicacion.idTipoInmueble = tipoinmueble.idTipoInmueble\r\n"
					+ "JOIN propiedad ON publicacion.idPropiedad = propiedad.idPropiedad\r\n"
					+ "JOIN direccion ON propiedad.idDireccion = direccion.idDireccion\r\n"
					+ "JOIN estado ON direccion.idEstado = estado.idEstado\r\n"
					+ "JOIN municipio ON direccion.idMunicipio = municipio.idMunicipio\r\n"
					+ "JOIN avenidas ON direccion.idAvenidas = avenidas.idAvenidas\r\n"
					+ "JOIN calles ON direccion.idCalles = calles.idCalles\r\n"
					+ "JOIN codigopostal ON direccion.idcodigoPostal = codigopostal.idcodigoPostal\r\n"
					+ "WHERE idPublicacion = ?;");
			
			ps.setInt(1, idPublicacion);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				detallesInmueble.setIdPublicacion(rs.getInt("idPublicacion"));
                detallesInmueble.setNombreCliente(rs.getString("cliente.nombre"));
                detallesInmueble.setIdEmpleado(rs.getInt("empleado.idEmpleado"));
                detallesInmueble.setNombreEmpleado(rs.getString("empleado.nombre"));
                detallesInmueble.setTelefonoEmpleado(rs.getString("empleado.telefono"));
                detallesInmueble.setFechaPublicacion(rs.getDate("fechaPublicacion"));
                detallesInmueble.setIdTipoInmueble(rs.getInt("tipoInmueble.idTipoInmueble"));
                detallesInmueble.setNombreTipo(rs.getString("tipoinmueble.nombreTipo"));
                detallesInmueble.setPrecio(rs.getDouble("precio"));
                detallesInmueble.setDescripcion(rs.getString("descripcion"));
                detallesInmueble.setNombreEstado(rs.getString("estado.Nombre"));
                detallesInmueble.setNombreMunicipio(rs.getString("municipio.Nombre"));
                detallesInmueble.setNombreAvenidas(rs.getString("avenidas.Nombre"));
                detallesInmueble.setAvenidas(rs.getInt("avenidas.Avenidas"));
                detallesInmueble.setNombreCalles(rs.getString("calles.Nombre"));
                detallesInmueble.setCalles(rs.getInt("calles.Calles"));
                detallesInmueble.setDetalle(rs.getString("direccion.Detalle"));
                detallesInmueble.setCodigoPostal(rs.getInt("codigopostal.codigoPostal"));
                detallesInmueble.setIdPropiedad(rs.getInt("propiedad.idPropiedad"));
                detallesInmueble.setMetrosCuadrados(rs.getDouble("propiedad.metrosCuadrados"));
                detallesInmueble.setMetrosCuadradosConstruidos(rs.getDouble("propiedad.metrosCuadradosConstruidos"));
                detallesInmueble.setCuartos(rs.getInt("propiedad.cuartos"));
                detallesInmueble.setCuartosServicio(rs.getInt("propiedad.cuartosServicio"));
                detallesInmueble.setAseos(rs.getInt("propiedad.aseos"));
                detallesInmueble.setAseosServicio(rs.getInt("propiedad.aseosServicio"));
                detallesInmueble.setEstacionamiento(rs.getInt("propiedad.estacionamiento"));
                detallesInmueble.setPiscina(rs.getBoolean("propiedad.piscina"));
                detallesInmueble.setCanchaTenis(rs.getBoolean("propiedad.canchaTenis"));
                detallesInmueble.setCanchaBasket(rs.getBoolean("propiedad.canchaBasket"));
                detallesInmueble.setCanchaFutbolSalon(rs.getBoolean("propiedad.canchaFutbolSalon"));
                detallesInmueble.setParque(rs.getBoolean("propiedad.Parque"));
                detallesInmueble.setJuegosInfantiles(rs.getBoolean("propiedad.juegosInfantiles"));
                detallesInmueble.setCanchaMultiusos(rs.getBoolean("propiedad.canchaMultiusos"));
                detallesInmueble.setGym(rs.getBoolean("propiedad.gym"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.Cerrar();
		}
		return detallesInmueble;
	}

	@Override
	public void comprar(int idPublicacion) throws Exception {
		try {
            this.Conectar();
            PreparedStatement ps = this.conexion.prepareStatement("UPDATE publicacion SET disponible = 0 WHERE idPublicacion = ?;");
            ps.setInt(1, idPublicacion);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }
		
	}




}
