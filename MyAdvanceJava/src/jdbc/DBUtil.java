package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
	
	public static final String DB_DRIVER = "org.postgresql.Driver";
	public static final String DB_URL = "jdbc:postgresql://localhost:8699/postgres";
	public static final String DB_USER = "postgres";
	public static final String DB_PASSWORD = "1998";
    
	public static Connection connection = null;
	
	static 
	{
		try 
		{
			Class.forName(DB_DRIVER);
			connection = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
		} 
		catch (Exception e) 
		{
			System.out.println(e);
		}
	}
	
	public static Connection getConnection()
	{
		return connection;
    }

}
