package com.mycompany.interfaces;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import com.mycompany.models.Venta;

public interface DAOVenta {

	public void registrar(Venta venta) throws Exception;
	public void actualizar(Venta venta);
	//public void eliminar(Venta venta);
	public List<Venta> buscarPorId(int id) throws Exception;
	public List<Venta> buscarTodos() throws SQLException;
	public List<Venta> buscarDesdeUnaFechaHastaOtra(Date fecha1, Date fecha2) throws SQLException;
}
