package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BatchUpdateDemo2 {

	public static void main(String[] args) throws SQLException
	{
		Connection connection = null;
		Statement pst = null;
	   try 
	   {
		  Class.forName("com.mysql.cj.jdbc.Driver");
		  connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/learn","root","0003pray");
		  pst = connection.createStatement();
		 
		  String s1 = "update demos set name = 'Pritam Ray' where city = 'prem nagar'";
		  String s2 = "delete from demos where name = 'Raju Verma'";
		  
		  pst.addBatch(s1);
		  pst.addBatch(s2);
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
	   finally 
	   {
		   connection.close();
	   }

	}

}
