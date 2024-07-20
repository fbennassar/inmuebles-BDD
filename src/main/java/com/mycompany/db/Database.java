package com.mycompany.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Database {
    
	// private final significa que no se puede cambiar el valor de la variable, es una constante
    protected Connection conexion;
    private final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private final String DB_URL = "jdbc:mysql://localhost/inmuebles"; //Si no han modificado los puertos, la ruta es esa (inmuebles es el nombre de la BDD)
    
    // Aca van las credenciales de la base de datos
    private final String USER = "root";
    private final String PASS = "";
    
    // Metodo que conecta a la base de datos y envia un mensaje de conexion exitosa
    public void Conectar() throws ClassNotFoundException {
        try {
            conexion = DriverManager.getConnection(DB_URL, USER, PASS);
            Class.forName(JDBC_DRIVER);
            System.out.println("Conexión exitosa");
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // Metodo que cierra la conexion a la base de datos y envia un mensaje de conexion cerrada
    public void Cerrar() throws SQLException{
        if (conexion != null) {
            if (!conexion.isClosed()) {
                conexion.close();
                System.out.println("Conexión cerrada");
            }
        }
    }
}