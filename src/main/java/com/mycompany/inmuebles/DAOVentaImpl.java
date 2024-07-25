package com.mycompany.inmuebles;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mycompany.db.Database;
import com.mycompany.interfaces.DAOVenta;
import com.mycompany.models.Venta;

public class DAOVentaImpl extends Database implements DAOVenta{

	@Override
	public void registrar(Venta venta) throws Exception {
		
		try {
			this.Conectar();
			PreparedStatement ps = this.conexion.prepareStatement("INSERT INTO venta (fechaVenta, idCliente, idEmpleado, idPublicacion, idPropiedad, idTipoInmueble) VALUES (?, ?, ?, ?, ?, ?);");
			ps.setDate(1, venta.getFechaVenta());
			ps.setInt(2, venta.getIdCliente());
			ps.setInt(3, venta.getIdEmpleado());
			ps.setInt(4, venta.getIdPublicacion());
			ps.setInt(5, venta.getIdPropiedad());
			ps.setInt(6, venta.getIdTipoInmueble());
			ps.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			this.Cerrar();
		}
		
	}

	@Override
	public void actualizar(Venta venta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Venta> buscarPorId(int id) throws SQLException {
		List<Venta> ventas = null;
		
		try {
			this.Conectar();
			PreparedStatement ps = this.conexion.prepareStatement("SELECT\r\n"
					+ "    idVenta,\r\n"
					+ "    fechaVenta,\r\n"
					+ "    tipoinmueble.nombreTipo,\r\n"
					+ "    publicacion.precio,\r\n"
					+ "    estado.Nombre,\r\n"
					+ "    municipio.Nombre,\r\n"
					+ "    cliente.nombre,\r\n"
					+ "    empleado.nombre\r\n"
					+ "FROM\r\n"
					+ "    venta\r\n"
					+ "JOIN tipoinmueble ON venta.idTipoInmueble = tipoinmueble.idTipoInmueble\r\n"
					+ "JOIN publicacion ON venta.idPublicacion = publicacion.idPublicacion\r\n"
					+ "JOIN propiedad ON venta.idPropiedad = propiedad.idPropiedad\r\n"
					+ "JOIN direccion ON propiedad.idDireccion = direccion.idDireccion\r\n"
					+ "JOIN estado ON direccion.idEstado = estado.idEstado\r\n"
					+ "JOIN municipio ON direccion.idMunicipio = municipio.idMunicipio\r\n"
					+ "JOIN cliente ON venta.idCliente = cliente.idCliente\r\n"
					+ "JOIN empleado ON venta.idEmpleado = empleado.idEmpleado\r\n"
					+ "WHERE\r\n"
					+ "    idVenta = ?;");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				ventas = new ArrayList<Venta>();
				Venta venta = new Venta();
				venta.setId(rs.getInt("idVenta"));
				venta.setFechaVenta(rs.getDate("fechaVenta"));
				venta.setTipoInmueble("tipoinmueble.nombreTipo");
				venta.setPrecio(rs.getDouble("publicacion.precio"));
				venta.setEstado(rs.getString("estado.Nombre"));
				venta.setMunicipio(rs.getString("municipio.Nombre"));
				venta.setNombreCliente(rs.getString("cliente.nombre"));
				venta.setNombreEmpleado(rs.getString("empleado.nombre"));
				
				ventas.add(venta);
			}
			rs.close();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.Cerrar();
		}
		
		return ventas;
	}

	@Override
	public List<Venta> buscarTodos() throws SQLException {
		List<Venta> ventas = null;
		
		try {
			this.Conectar();
			PreparedStatement ps = this.conexion.prepareStatement("SELECT\r\n"
					+ "    idVenta,\r\n"
					+ "    fechaVenta,\r\n"
					+ "    tipoinmueble.nombreTipo,\r\n"
					+ "    publicacion.precio,\r\n"
					+ "    estado.Nombre,\r\n"
					+ "    municipio.Nombre,\r\n"
					+ "    cliente.nombre,\r\n"
					+ "    empleado.nombre\r\n"
					+ "FROM\r\n"
					+ "    venta\r\n"
					+ "JOIN tipoinmueble ON venta.idTipoInmueble = tipoinmueble.idTipoInmueble\r\n"
					+ "JOIN publicacion ON venta.idPublicacion = publicacion.idPublicacion\r\n"
					+ "JOIN propiedad ON venta.idPropiedad = propiedad.idPropiedad\r\n"
					+ "JOIN direccion ON propiedad.idDireccion = direccion.idDireccion\r\n"
					+ "JOIN estado ON direccion.idEstado = estado.idEstado\r\n"
					+ "JOIN municipio ON direccion.idMunicipio = municipio.idMunicipio\r\n"
					+ "JOIN cliente ON venta.idCliente = cliente.idCliente\r\n"
					+ "JOIN empleado ON venta.idEmpleado = empleado.idEmpleado\r\n");
			ResultSet rs = ps.executeQuery();
			ventas = new ArrayList<Venta>();
			while (rs.next()) {
				Venta venta = new Venta();
				venta.setId(rs.getInt("idVenta"));
				venta.setFechaVenta(rs.getDate("fechaVenta"));
				venta.setTipoInmueble(rs.getString("tipoinmueble.nombreTipo"));
				venta.setPrecio(rs.getDouble("publicacion.precio"));
				venta.setEstado(rs.getString("estado.Nombre"));
				venta.setMunicipio(rs.getString("municipio.Nombre"));
				venta.setNombreCliente(rs.getString("cliente.nombre"));
				venta.setNombreEmpleado(rs.getString("empleado.nombre"));
				
				ventas.add(venta);
			}
			rs.close();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.Cerrar();
		}
		
		return ventas;
	}

	@Override
	public List<Venta> buscarDesdeUnaFechaHastaOtra(Date fecha1, Date fecha2) throws SQLException {
		List<Venta> ventas = null;
		
		try {
			this.Conectar();
			PreparedStatement ps = this.conexion.prepareStatement("SELECT\r\n"
					+ "    idVenta,\r\n"
					+ "    fechaVenta,\r\n"
					+ "    tipoinmueble.nombreTipo,\r\n"
					+ "    publicacion.precio,\r\n"
					+ "    estado.Nombre,\r\n"
					+ "    municipio.Nombre,\r\n"
					+ "    cliente.nombre,\r\n"
					+ "    empleado.nombre\r\n"
					+ "FROM\r\n"
					+ "    venta\r\n"
					+ "JOIN tipoinmueble ON venta.idTipoInmueble = tipoinmueble.idTipoInmueble\r\n"
					+ "JOIN publicacion ON venta.idPublicacion = publicacion.idPublicacion\r\n"
					+ "JOIN propiedad ON venta.idPropiedad = propiedad.idPropiedad\r\n"
					+ "JOIN direccion ON propiedad.idDireccion = direccion.idDireccion\r\n"
					+ "JOIN estado ON direccion.idEstado = estado.idEstado\r\n"
					+ "JOIN municipio ON direccion.idMunicipio = municipio.idMunicipio\r\n"
					+ "JOIN cliente ON venta.idCliente = cliente.idCliente\r\n"
					+ "JOIN empleado ON venta.idEmpleado = empleado.idEmpleado\r\n"
					+ "WHERE\r\n"
					+ "    fechaVenta BETWEEN ? AND ?;");
			ps.setDate(1, fecha1);
			ps.setDate(2, fecha2);
			ResultSet rs = ps.executeQuery();
			ventas = new ArrayList<Venta>();
			while (rs.next()) {
				Venta venta = new Venta();
				venta.setId(rs.getInt("idVenta"));
				venta.setFechaVenta(rs.getDate("fechaVenta"));
				venta.setTipoInmueble(rs.getString("tipoinmueble.nombreTipo"));
				venta.setPrecio(rs.getDouble("publicacion.precio"));
				venta.setEstado(rs.getString("estado.Nombre"));
				venta.setMunicipio(rs.getString("municipio.Nombre"));
				venta.setNombreCliente(rs.getString("cliente.nombre"));
				venta.setNombreEmpleado(rs.getString("empleado.nombre"));
				
				ventas.add(venta);
			}
			rs.close();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.Cerrar();
		}
		
		return ventas;
	
	}

	}




