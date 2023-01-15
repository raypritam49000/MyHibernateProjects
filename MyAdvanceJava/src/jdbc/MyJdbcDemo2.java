package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MyJdbcDemo2 {

	public static void main(String[] args) {
	Connection c = null;
	
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
		    c = DriverManager.getConnection("jdbc:mysql://localhost:3306/connect","root","0003pray");
			System.out.println(c);
			
		    PreparedStatement ps = c.prepareStatement("insert into student values(233,'Rahul'),(123,'sham')");
		    int value = ps.executeUpdate();
		    
		    if(value>0) {
		    	System.out.println("Value are insert....");
		    }
		    else {
		    	System.out.println("Value are not insert....");
		    }
		    
		   ResultSet rs = ps.executeQuery("Select * from student");
		  
		   while(rs.next()) 
		   {
			  System.out.println(rs.getInt("id")+" "+rs.getString("name"));
		   }
		
		   }
		
	   catch(Exception e)
		{
			e.getStackTrace();
		}	
			
	   finally 
	   {
		
			try
			{
				c.close();
			} 
			catch (SQLException e)
			{
				
				e.printStackTrace();
			}
			
	   }

	}

}
