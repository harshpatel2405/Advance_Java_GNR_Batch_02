package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;


public class TestConnection {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
	
		try
		{
			Connection con = JDBCUtils.getConnection();
			
			if(con != null)
			{
				System.out.println("Connection Established Successfully...");
			}
			
			System.out.println("Enter ID : ");
			int id = sc.nextInt();
			
			
			String Query = "Select * from student where id = ?";
			
			PreparedStatement ps = con.prepareStatement(Query);
			
			ps.setInt(1, id);
			
			
			ResultSet rs = ps.executeQuery();
			
			
			while(rs.next())
			{
				System.out.println(rs.getInt("id") + "\t"+rs.getString("name") +"\t"+rs.getInt("age")+"\t"+rs.getString("email") );
			}
			
			JDBCUtils.CloseConnection(con);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
