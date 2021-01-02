package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionSql {

// Se sacan en variables independientes, el controlador la URL de conexión, el usario y la clave
	private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String URL_DB = "jdbc:mysql://localhost:3306/db_apppostres?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	private static final String USER_DB = "AppPostres";
	private static final String PASS_DB = "Postres2021*";
	protected static Connection conexion = null;
	
//Bloque de código para utilizar el controlador de conexión una sola vez sin estarlo utilizando en cada conexión
	static {
		try {
			Class.forName(JDBC_DRIVER);
		} catch (ClassNotFoundException e) {
			System.out.println("Error al cargar el controlador");
			e.printStackTrace();// Rastreo de pila, en caso de que suceda un error para saber cual fue el origen del error
		}
	}

	// Método para establecer la conexión con la base de datos
	public static Connection conectar() {

		try {

			conexion = DriverManager.getConnection(URL_DB, USER_DB, PASS_DB);

			//System.out.println("Conexión OK a la base de datos");
		} catch (SQLException e) {
			System.out.println("Error en la conexión SQL");
			e.printStackTrace();// Rastreo de pila, en caso de que suceda un error para saber cual fue el origen del error
		}

		return conexion;
	}

	public void cerrarConexion() throws SQLException {
		if (conexion != null) {
			if(!conexion.isClosed()) {
				conexion.close();
				System.out.println("Conexión a base de datos finalizada");
			}

		}
	}

}
