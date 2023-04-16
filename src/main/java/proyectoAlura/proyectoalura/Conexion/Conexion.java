package proyectoAlura.proyectoalura.Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

	private static Conexion conexion = new Conexion();
	private Connection conector;

	public static Conexion getConexion() {

		if (conexion == null) {

			conexion = new Conexion();

		}

		return conexion;

	}

	public Connection getConector() { //probado
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conector = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/baseAluraSencilla?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=America/Bogota"
							+ "",
					"root", "foxone");
			
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("error al conectar a la bd: "+  "error:" + e.getMessage() + e.getCause());
		}

		return conector;
	}

}
