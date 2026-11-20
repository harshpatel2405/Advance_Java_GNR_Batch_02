package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class ProjectJDBC {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		try
		{
			Connection con = JDBCUtils.getConnection();
			if(con != null)
			{
				System.out.println("Connection Established Successfully...");
			}
			
			int choice;
			String query;
			PreparedStatement ps;
			do
			{
				System.out.println("1. Add Single Data\n2. Add Multiple Data\n3. Display All Records\n4. Update a Record\n5. Delete a Record\n6. Search a Record\n7. Sort All Records\n8. Exit\nSelect Your Choice : ");
				choice = sc.nextInt();
				
				switch(choice)
				{
				case 1 : 
					query = "insert into student values (?,?,?,?)";
					ps= con.prepareStatement(query);
					
					System.out.println("Enter id, name, age, email:");
					int id = sc.nextInt();
					sc.nextLine();  // Consume leftover newline
					String name = sc.nextLine();
					int age = sc.nextInt();
					sc.nextLine();  // Consume leftover newline
					String email = sc.nextLine();
					
					
					ps.setInt(1, id);					
					ps.setString(2, name);
					ps.setInt(3, age);					
					ps.setString(4, email);


					int result = ps.executeUpdate();
					System.out.println(result + " rows added successfullly.");
					break;
					
				case 2 : 
					int n  ;
					
					System.out.println("Enter number of records you want to add : ");
					n = sc.nextInt();
					Student [] s = new Student[n];;
					query = "insert into student values (?,?,?,?)";

					ps= con.prepareStatement(query);
					
					for(int i = 0; i < n;i++)
					{
						
						System.out.println("Enter id , name ,age , email  : ");
					     id = sc.nextInt();
					     sc.nextLine();  // Consume leftover newline
					     name = sc.nextLine();
						 age = sc.nextInt();
						 sc.nextLine();  // Consume leftover newline
						 email = sc.nextLine();
						 s[i] = new Student(id, name ,age,email);
					}
					
					 for(Student x : s)
			          {
			                ps.setInt(1, x.id);
			                ps.setString(2, x.name);
			                ps.setInt(3, x.age);
			                ps.setString(4, x.email);

			                ps.addBatch();
			          }
					 
					   int row[] = ps.executeBatch();

					   System.out.println(row.length + " rows added Successfully....");
//			            break;
					
					
				}
			}while(choice != 8);
			
			JDBCUtils.CloseConnection(con);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
