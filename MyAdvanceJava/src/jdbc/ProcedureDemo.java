package jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ProcedureDemo {

	public static void main(String[] args) 
	{
		Connection connection = null;
		
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ray","root","1998");
			System.out.println(connection);
			
			Scanner sc = new Scanner(System.in);
			
			System.out.print("Enter id : ");
			int id = sc.nextInt();
			
			System.out.print("Enter name : ");
			String name = sc.next();
			
			
			CallableStatement cst = connection.prepareCall("{CALL MyStoredProcedure4(?,?)}");
			
			cst.setInt(1,id);
			cst.setString(2,name);
			
			int i = cst.executeUpdate();
			
			if(i>0) 
			{
			System.out.println("Values are inserted...");	
			}
			else
			{
				System.out.println("Values are not inserted...");
			}
			
			 cst = connection.prepareCall("{CALL MyStoredProcedure4()}");
			 ResultSet rs = cst.executeQuery();
			 
			 while(rs.next())
			 {
				 System.out.println(rs.getInt("id")+" "+rs.getString("name"));
			 }
			 
		} 
		catch (Exception e) 
		{
			e.getMessage();
		}
		finally 
		{
			try 
			{
				connection.close();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}

	}

}
