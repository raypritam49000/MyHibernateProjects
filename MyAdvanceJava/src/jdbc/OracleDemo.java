package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class OracleDemo {

	public static void main(String[] args) 
	{
		Connection connection = null;
		
		try 
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		    connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","root","1998");
			System.out.println(connection);
		

			Scanner sc = new Scanner(System.in);
			
			System.out.print("Enter id : ");
			int id = sc.nextInt();
			
			System.out.print("Enter name : ");
			String name = sc.nextLine();
			       name = sc.nextLine();
			
			PreparedStatement pst = connection.prepareStatement("insert into student values(?,?)");
			pst.setInt(1,id);
			pst.setString(2,name);
			
			int i = pst.executeUpdate();
			
			if(i>0) 
			{
				System.out.println("Values are inserted...");
			}
			else 
			{
			   	System.out.println("Values are not inserted...");
			}
			
		     pst = connection.prepareStatement("select * from student");
		     
		    ResultSet rs =  pst.executeQuery();
		    
		    while(rs.next()) 
		    {
		    	System.out.println(rs.getInt("id")+" "+rs.getString("name"));
		    }
			
		} 
		
		catch (Exception e) 
		{
			e.getSuppressed();
		}
		
		finally 
		{
			try 
			{
			   connection.close();
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}
		}

	}

}
