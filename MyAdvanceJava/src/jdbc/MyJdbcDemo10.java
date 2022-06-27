package jdbc;

import java.io.FileWriter;
import java.io.Reader;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MyJdbcDemo10 {

	public static void main(String[] args) throws Exception 
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/learn","root","0003pray");
		PreparedStatement pst = connection.prepareStatement("select * from filetable");
		
		ResultSet rs= pst.executeQuery();
		rs.next();
		
		Clob cb = rs.getClob(2);
		Reader r = cb.getCharacterStream();
		
		FileWriter fw =  new FileWriter("E:\\ColorHexCodeStringXml.txt");
		
		int i;
		
		while((i=r.read())!=-1)
		{
			fw.write((char)i);
		}
		
		fw.close();
		connection.close();
		System.out.println("Sucessfull");
		
	}

}
