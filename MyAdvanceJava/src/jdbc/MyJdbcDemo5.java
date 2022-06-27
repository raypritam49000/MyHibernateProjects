package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class MyJdbcDemo5 {

	public static void main(String[] args) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/connect","root","0003pray");
		
		Scanner input = new Scanner(System.in);
		System.out.println("Enter id");
		int id = input.nextInt();
		
		System.out.println("Enter name");
		String name = input.next();
		
		PreparedStatement ps = c.prepareStatement("insert into student values(?,?)");
		ps.setInt(1,id);
		ps.setString(2,name);
		
	    int i =	ps.executeUpdate();
	    
	    if(i>0) 
	    {
	    	System.out.println("Values are inserted...");
	    }
	    else
	    {
	    	System.out.println("Values are not inserted...");
	    }
		

	}

}
