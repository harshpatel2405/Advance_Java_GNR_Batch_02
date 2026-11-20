package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class BatchStudentCheck
{
    public static void main(String[] args)
    {
        try
        {
            Connection con = JDBCUtils.getConnection();

            if(con != null)
            {
                System.out.println("Connection Established Successfully...");
            }

            Student s[] = {
            	    new Student(201, "Ram", 56, "ramfromayodhya@ayodhya.com"),
            	    new Student(202, "Lakshman", 32, "lakshmanfromayodhya@ayodhya.com"),
            	    new Student(203, "Bharat", 35, "bharatfromayodhya@ayodhya.com"),
            	    new Student(204, "Hanuman", 40, "hanumanfromkishkindha@kishkindha.com"),
            	    new Student(205, "Ravan", 50, "ravanfromlanka@lanka.com"),
            	    new Student(206, "Krishna", 34, "krishnafromgokul@mathura.com"),
            	    new Student(207, "Balram", 45, "balramfromgokul@mathura.com"),
            	    new Student(208, "Arjun", 23, "arjunpandava@hastinapur.com"),
            	    new Student(209, "Karna", 28, "karnafromangadesh@angadesh.com"),
            	    new Student(210, "Yudhishthir", 38, "yudhishthirpandava@hastinapur.com")
            	};
            String query = "INSERT INTO student VALUES (?,?,?,?)";

            PreparedStatement ps = con.prepareStatement(query);

            for(Student x : s)
            {
                ps.setInt(1, x.id);
                ps.setString(2, x.name);
                ps.setInt(3, x.age);
                ps.setString(4, x.email);

                ps.addBatch();
            }

            int result[] = ps.executeBatch();

            for(int x : result)
            {
                System.out.println(
                    x == 1 ? "Row Added Successfully" : "Row Not Added"
                );
            }

            ps.close();
            JDBCUtils.CloseConnection(con);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}