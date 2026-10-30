package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class JDBCConnection {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/java";
		String username = "root";
		String password = "root123";
		try
		{
//			1. load the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
//			2. create a connection 
			Connection con = DriverManager.getConnection(url , username , password);
			
//			3. prepare a statement 
			Statement st = con.createStatement();
			
//			4. execute a query 
			String query = "Select * from student";
			
//			5 process the result 
			ResultSet rs = st.executeQuery(query);
			
			while(rs.next())
			{
				System.out.println(rs.getInt("id") + rs.getString("name") +rs.getInt("age") );
			}
			
//			6 close the connection
			con.close();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
