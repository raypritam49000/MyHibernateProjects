package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BatchUpdateDemo {

	public static void main(String[] args)
	{
		Connection connection = null;
		PreparedStatement pst = null;
	   try 
	   {
		  Class.forName("com.mysql.cj.jdbc.Driver");
		  connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/learn","root","0003pray");
		  pst = connection.prepareStatement("insert into demos values(?,?)");
		 
		  pst.setString(1,"Chandan Kumar");
		  pst.setString(2,"Ropar");
		  pst.addBatch();
		  
		  pst.setString(1,"Gautam Sahani");
		  pst.setString(2,"Uk");
		  pst.addBatch();
		  
		  pst.executeBatch();
		  
			 ResultSet rs = pst.executeQuery("select * from demos");
			 while(rs.next()) 
			 {
				 System.out.println(rs.getString("name")+" "+rs.getString("city"));
			 }
		  
	   } 
	   catch (Exception e) 
	   {
		System.out.println(e);
	   }

	}

}
