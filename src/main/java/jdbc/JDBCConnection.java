package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.cj.protocol.Resultset;

public class JDBCConnection {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/adv_java";
		String username = "root";
		String password = "root";
		try
		{
//			1. load the driver
			Class.forName("com.mysql.cj.jdbc.driver");
			
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
				System.out.println(rs.getInt("id"));
			}
			
//			6 close the connection
			con.close();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
