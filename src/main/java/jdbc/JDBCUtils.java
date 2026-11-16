package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtils {
	private static String url = "jdbc:mysql://localhost:3306/java";
	private static String username = "root";
	private static String password = "root123";	
	
	protected static Connection getConnection() throws ClassNotFoundException , SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url , username , password);
		
		return con;
	}
	
	protected static void CloseConnection(Connection obj) throws SQLException
	{
		if(obj != null)
		{
			obj.close();
			System.out.println("Connection Closed Successfullly...");
		}
	}
}
