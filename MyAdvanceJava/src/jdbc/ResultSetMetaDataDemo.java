package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class ResultSetMetaDataDemo{

	public static void main(String[] args) 
	{
		Connection con = null;
	    try 
	    {
	    	Class.forName("org.postgresql.Driver");
	    	con = DriverManager.getConnection("jdbc:postgresql://localhost:8699/postgres","postgres","1998");
	    	System.out.println(con);
	    	
	    	Statement st = con.createStatement();
	    	
	    	ResultSet rs = st.executeQuery("select * from student");
	    	
	    	ResultSetMetaData rsm = rs.getMetaData();
	    	
	        int count = rsm.getColumnCount();
	        System.out.println("Column = "+count);
	    	
	    	for(int i=1; i<=count; i++) 
	    	{
	    		String name1 = rsm.getColumnClassName(i);
	    		System.out.println(name1);
	    		
	    		String name2 = rsm.getColumnName(i);
	    		System.out.println(name2);
	    		
	    		String name3 = rsm.getColumnTypeName(i);
	    		System.out.println(name3);
	    		
	    		int name4 = rsm.getColumnType(i);
	    		System.out.println(name4);
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
				con.close();
			} 
	    	catch (Exception e2) 
	    	{
				e2.printStackTrace();
			}
	    	
	    }

	}

}
