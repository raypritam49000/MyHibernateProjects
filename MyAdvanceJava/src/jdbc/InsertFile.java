package jdbc;

import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class InsertFile {

	public static void main(String[] args) throws Exception 
	{
	    Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/learn","root","0003pray");
		
		PreparedStatement pst = connection.prepareStatement("insert into filetable values(?,?)");
		
		File file = new File("E:\\ColorHexCodeStringXml.txt");
		FileReader fr = new FileReader(file);
		
		pst.setInt(1,100);
		pst.setCharacterStream(2,fr,file.length());
		
		int i = pst.executeUpdate();
		
		if(i>0) 
		{
			System.out.println("File are inserted..");
		}
		else 
		{
			System.out.println("File are not inserted...");
		}
		
        connection.close();
	}

}
