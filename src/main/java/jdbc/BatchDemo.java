package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class BatchDemo {
	public static void main(String[] args) {
		try
		{
			Connection con =  JDBCUtils.getConnection();
			
			if(con != null)
			{
				System.out.println("Connection Established Successfully...");
			}
			
			
			String query = "Insert into student values (?,?,?,?)";
			
			PreparedStatement ps = con.prepareStatement(query);
			
			
			ps.setInt(1, 101);
			ps.setString(2,"Krishna");
			ps.setInt(3,  34);
			ps.setString(4, "krishnafromgokul@mathura.com");
			ps.addBatch();

			ps.setInt(1, 102);
			ps.setString(2,"Balram");
			ps.setInt(3,  45);
			ps.setString(4, "balramfromgokul@mathura.com");
			ps.addBatch();
			

			ps.setInt(1, 103);
			ps.setString(2,"Arjun");
			ps.setInt(3,  23);
			ps.setString(4, "arjunpandava@hastinapur.com");
			ps.addBatch();
			
			ps.setInt(1, 104);
			ps.setString(2,"Ram");
			ps.setInt(3,  56);
			ps.setString(4, "ramfromayodhya@ayodhya.com");
			ps.addBatch();
			

			int [] result = ps.executeBatch();
			
			for(int x : result)
			{
				System.out.println(x);
			}
			
			JDBCUtils.CloseConnection(con);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
