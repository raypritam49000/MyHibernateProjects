package jdbc;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InsertImage {

	public static void main(String[] args) 
	{
		Connection connection = null;
		PreparedStatement pst = null;
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/learn","root","0003pray");
		    pst = connection.prepareStatement("insert into imagtable values(?,?)");
		    
		    FileInputStream fin = new FileInputStream("C:\\Users\\AndroTech 4u\\Downloads\\Video\\ReturnBook.png");
		    
		    pst.setString(1,"Raj Kumar");
		    pst.setBinaryStream(2,fin,fin.available());
		    
		   int value =  pst.executeUpdate();
		   
		   if(value>0) 
		   {
			   System.out.println("Image are inserted...");
		   }
		   else 
		   {
			   System.out.println("Image are not inserted...");
		   }
		  
			pst = connection.prepareStatement("select * from imagtable");
			
		   ResultSet rs = pst.executeQuery();
		   
		   while(rs.next()) 
		   {
			System.out.println(rs.getString("name")+" "+rs.getString("image"));   
		   }
			
		} 
		catch (Exception e) 
		{
			System.out.println(e);
		}
		finally 
		{
			try {
				connection.close();
				} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}

	}

}
