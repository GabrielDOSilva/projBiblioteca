package biblioteca.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MysqlConnection {

    private static String url = "jdbc:mysql://localhost:3306/biblioteca";
    private static String user = "root";
    private static String pw = "G#briel0796";
    private static String driver = "com.mysql.cj.jdbc.Driver";
    
    public static Connection getConnection() throws SQLException{
        try {
            Class.forName(driver);
            return DriverManager.getConnection(url,user,pw);
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
	
	
}
