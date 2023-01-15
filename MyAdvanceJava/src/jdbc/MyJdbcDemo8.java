package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class MyJdbcDemo8 
{   

	public static void main(String[] args) 
	{
		Connection connection = null;
		PreparedStatement pst = null;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/learn","root","0003pray");
			pst = connection.prepareStatement("create table demo(name varchar(200) not null,city varchar(200) not null)");
		    int v = pst.executeUpdate();
		    if(v>0) 
		    {
		    	System.out.println("Table are not Created...");
		    }
		    else 
		    {
		    	System.out.println("Table are created...");
		    }
		    
		    Scanner sc = new Scanner(System.in);
		    
		    System.out.println("Enter Name : ");
		    String name = sc.next();
		    
		    System.out.println("Enter City : ");
		    String city = sc.next();
		    
		    pst = connection.prepareStatement("insert into demo values(?,?)");
		    pst.setString(1,name);
		    pst.setString(2,city);
		    
		    int i = pst.executeUpdate();
		    
		    if(i>0)
		    {
		     System.out.println("Values are inserted");	
		    }
		    else 
		    {
		    	System.out.println("Values are not  inserted");
		    }
		    
		    System.out.println("Enter Name : ");
		    String names= sc.next();
		
		    pst = connection.prepareStatement("Update demo set name = 'Raj',city = 'Prem Nagar' where name = ? ");
		    pst.setString(1,names);
		    
		    int value = pst.executeUpdate();
		    
		     if(value>0)
		     {
		    	 System.out.println("Values are Updated...");
		     }
		     else
		     {
		    	 System.out.println("Values are  not Updated...");
		     }
		     
		     pst = connection.prepareStatement("select * from demo ");
		     
		     ResultSet rs = pst.executeQuery();
		     
		     while(rs.next()) 
		     {
		    	 System.out.println(rs.getString("name")+" "+rs.getString("city"));
		     }
		     
		     pst = connection.prepareStatement("drop table demo");
			    
			 value = pst.executeUpdate();
			    
			     if(value>0)
			     {
			    	 System.out.println("Table are not delete...");
			     }
			     else
			     {
			    	 System.out.println("Table are  delete...");
			     }
		} 
		catch (Exception e)
		{
			System.out.println(e);
		}
		
		finally 
		{
		  try 
		   {
			connection.close();
		   } 
		 catch (Exception e2) 
		  {
			System.out.println(e2);
		  }	
		}
	}
}
