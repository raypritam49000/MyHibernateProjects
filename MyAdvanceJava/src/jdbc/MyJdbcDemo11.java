package jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MyJdbcDemo11 {

	public static void main(String[] args) 
	{
        Connection connection = null;
		
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ray","root","1998");
			System.out.println(connection);
			
			
			CallableStatement cst = connection.prepareCall("{CALL GetOrderCountByStatus9('punjab',@total)}");
			
			ResultSet rst = cst.executeQuery();
			
			while(rst.next()) 
			{
				System.out.println(rst.getInt("@total"));
			}
			
			System.out.println("Sucess...");
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
				catch (Exception e) 
				{
					System.out.println(e);
				}
			}

	}

}
