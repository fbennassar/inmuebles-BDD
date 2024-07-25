package com.mycompany.interfaces;

import java.util.List;

import com.mycompany.models.VistaPublicacion;

public interface DAOVistaPublicacion {

	public List<VistaPublicacion> buscarTodos() throws Exception;
}
