package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Prepare {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/java";
		String username = "root";
		String password = "root123";
		Scanner sc=  new Scanner(System.in);
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con =DriverManager.getConnection(url , username, password);
			
			while(true)
			{
				System.out.print("\n1. Retrive all data\n2. Insert Data\n3. Exit\nSelect Choice : ");
				int choice = sc.nextInt();
			
				if(choice == 1)
				{
					String query = "select * from student";
					PreparedStatement ps = con.prepareStatement(query);
					
					ResultSet rs = ps.executeQuery();

					
					System.out.println("ID\tName\tAge\tEmail\n--\t----\t---\t-----");
					while(rs.next())
					{
						System.out.println(rs.getInt("id") + "\t" + rs.getString("name") + "\t" + rs.getInt("age") + "\t" + rs.getString("email"));
					}
				}
				else if(choice ==2 )
				{	
					String query="Insert into student values (?,?,?,?)";
				
					System.out.print("Enter id : ");
					int id = sc.nextInt();
					System.out.print("Enter name : ");
					String name = sc.next();
					System.out.print("Enter Age : ");
					int age = sc.nextInt();
					System.out.print("Enter Email : ");
					String email = sc.next();
				
					PreparedStatement ps = con.prepareStatement(query);
				
					ps.setInt(1, id);
					ps.setString(2, name);
					ps.setInt(3, age);
					ps.setString(4, email);
				
					int rows = ps.executeUpdate();
				
					System.out.println(rows + " row/s inserted successfully");
				
				}
				else if(choice == 3)
				{
					System.out.println("Program Ended Successfully...");
					break;
				}
				else
				{
					System.out.println("Select Correct Choice\n");
				}
			}
			con.close();
		}catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
