package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class InsertDemo {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/java";
		String username = "root";
		String password = "root123";
		try
		{
			// load the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// create a connection
			Connection con = DriverManager.getConnection(url , username , password);
			
            // create a statement
			Statement st = con.createStatement();
			
			// prepare a sql query
			String query = "Insert into student values(2, 'vasu',23,'vasu@gmail.com')";
			
			// process the result
			int rows = st.executeUpdate(query);
			
			System.out.println(rows + " rows inserted successfullly...");
			
			
			// close the connection
			con.close();
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
