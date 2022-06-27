package jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

public class ProcedureDemo1 
{

	public static void main(String[] args) 
	{
		Connection connection = null;
		try 
		{
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/learn","root","1998");
		System.out.println(connection);
		
		CallableStatement cst = connection.prepareCall("? = {CALL F_Dist3D(?,?)}");
		
		cst.setDouble(2, 20.5);
		cst.setDouble(3, 10.3);
		
		cst.registerOutParameter(1,Types.DOUBLE);
		
		cst.execute();
		
		double dist = cst.getDouble(1);
		
		System.out.println("dist = "+dist);
		
		cst.close();
		
		}
		
		catch(Exception e) 
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
