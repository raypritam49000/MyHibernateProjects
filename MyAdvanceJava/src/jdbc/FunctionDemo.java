package jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

public class FunctionDemo 
{

	public static void main(String[] args) 
	{
		Connection c = null;
		
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
		    c =	DriverManager.getConnection("jdbc:mysql://localhost:3306/learn","root","1998");
		    System.out.println(c);
		    
		    CallableStatement cst = c.prepareCall("{?=call F_Dist3D(?,?)}");
		    
		    cst.setInt(2,10);
		    cst.setInt(3,10);
		    cst.registerOutParameter(1,Types.INTEGER);
		    
		    cst.execute();
		    
		    int sum = cst.getInt(1);
		    System.out.println("sum = "+sum);
		    
		} 
		
		catch (Exception e) 
		{
			System.out.println(e);
		}
		
		finally 
		{
		   try 
		   {
			  c.close();
		   }
		   catch (Exception e2) 
		   {
			  System.out.println(e2);
		   }	
		}
	}

}
