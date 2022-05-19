package biblioteca.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PSQLConnection {

	private static String url = "";
	private static String user = "";
	private static String pass = "";
	private static Connection connection = null;
	
	
	public static Connection getConnection() {
		return connection;
	}
	
	static {
		conectar();
	}
	
	public void SingleConectionBanco() {
		conectar();
	}
	
	private static void conectar() {
		
		try {
			
			if(connection == null) {
				Class.forName("org.postgresql.Driver");
				connection = DriverManager.getConnection(url, user, pass);
				connection.setAutoCommit(false);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();

		}
		
	}
	
}
