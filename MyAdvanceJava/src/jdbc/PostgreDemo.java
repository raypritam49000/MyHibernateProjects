package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class PostgreDemo {

	public static void main(String[] args) 
	{
		Connection c = null;
		try 
		{
			Class.forName("org.postgresql.Driver");
			c = DriverManager.getConnection("jdbc:postgresql://localhost:8699/postgres","postgres","1998");
			System.out.println(c);
			
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter the id : ");
			int id = sc.nextInt();
			
			System.out.println("Enter the name :");
			String name = sc.nextLine();
			       name = sc.nextLine();
			
			
			PreparedStatement pst = c.prepareStatement("insert into student values(?,?)");
			pst.setInt(1,id);
			pst.setString(2, name);
			
			int i = pst.executeUpdate();
			
			if(i>0) 
			{
			    System.out.println("Values are inserted...");	
			}
			else 
			{
				System.out.println("Values are not inserted...");
			}
			
			 pst = c.prepareStatement("select * from student");
			 
			 ResultSet rs = pst.executeQuery();
			 
			 while(rs.next()) 
			 {
				System.out.println(rs.getInt("id")+" "+rs.getString("name")); 
			 }
			
		 } 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			try 
			{
				c.close();
			} 
			catch (Exception e2) 
			{
				e2.printStackTrace();
			}
		}

	}

}
