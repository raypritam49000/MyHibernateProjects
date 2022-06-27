package jdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class DataBaseMetaDataDemo 
{

	public static void main(String[] args) 
	{
		Connection con = null;
		try 
		{
			Class.forName("org.postgresql.Driver");
	    	con = DriverManager.getConnection("jdbc:postgresql://localhost:8699/postgres","postgres","1998");
	    	System.out.println(con);
	    	
	    	DatabaseMetaData dbms = con.getMetaData();
	    	
	    	System.out.println(dbms.getURL());
	    	System.out.println(dbms.getDriverName());
	    	System.out.println(dbms.getDriverVersion());
	    	System.out.println(dbms.getDatabaseMajorVersion());
	    	System.out.println(dbms.getDatabaseMinorVersion());
	    	System.out.println(dbms.getDatabaseProductName());
	    	System.out.println(dbms.getDatabaseProductVersion());
	    	System.out.println(dbms.getCatalogSeparator());
	    	System.out.println(dbms.getCatalogTerm());
	    	System.out.println(dbms.getJDBCMajorVersion());
	    	System.out.println(dbms.getJDBCMinorVersion());
	    	
	    	ResultSet rs = dbms.getTables(null, null, null, new String[] {"TABLE"});
	    	
	    	while(rs.next()) 
	    	{
	    		System.out.println(rs.getInt(1));
	    		System.out.println(rs.getString(2));
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
				con.close();
			} 
			catch (Exception e2) 
			{
				System.out.println(e2);
			}
			
		}

	}

}
