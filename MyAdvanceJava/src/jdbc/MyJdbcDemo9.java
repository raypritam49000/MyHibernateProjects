package jdbc;

import java.io.FileOutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MyJdbcDemo9 {

	public static void main(String[] args) 
	{
		Connection connection = null;
		PreparedStatement ps = null;
		
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/learn","root","0003pray");
			ps = connection.prepareStatement("select * from imagtable");
			
			ResultSet rs = ps.executeQuery();
			rs.next();
			
		    Blob blob = rs.getBlob(2);
		    byte[] b = new byte[(int)blob.length()];
		    b = blob.getBytes(1, (int)blob.length());
		    
		    FileOutputStream fout = new FileOutputStream("C:\\Users\\AndroTech 4u\\Downloads\\Video\\ReturnBook.png");
		    fout.write(b);
		    
		    fout.close();
		    System.out.println("ok");
		    
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
