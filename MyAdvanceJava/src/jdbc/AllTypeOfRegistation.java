package jdbc;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Properties;

public class AllTypeOfRegistation 
{

	public static void main(String[] args) 
	{
 
		try 
		{
			// 1st way (Standards)
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/learn","root","0003pray");
			System.out.println(connection1);
			
			// 2nd way
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			Connection connection2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/learn","root","0003pray");
			System.out.println(connection2);
			
			//3rd way
			Driver d = new com.mysql.cj.jdbc.Driver();
			Properties p=new Properties();
			p.put("user","root");
			p.put("password","0003pray");
			Connection connection3 = d.connect("jdbc:mysql://localhost:3306/learn",p);
			System.out.println(connection3);
			
			//4th way
			System.setProperty("jdbc.drivers","com.mysql.cj.jdbc.Driver");
			Properties dbprop = new Properties();
			dbprop.put("user","root");
			dbprop.put("password","0003pray");
			Connection connection4 = DriverManager.getConnection("jdbc:mysql://localhost:3306/learn",dbprop);
			System.out.println(connection4);
		
		} 
		catch (Exception e) 
		{
			System.out.println(e);
		}

	}

}
