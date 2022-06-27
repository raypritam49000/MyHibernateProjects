package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class MyJdbcDemo4 {

	public static void main(String[] args) throws Exception {
	
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/connect","root","0003pray");
		System.out.println(c);

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Id");
		int id = sc.nextInt();
		
		System.out.println("Enter name");
		String name = sc.next();
		
		Statement s = c.createStatement();
		int value = s.executeUpdate("insert into student values("+id+",'"+name+"')");
		
		if(value>0) {
			System.out.println("Values are inserted....");
		}
		else {
			System.out.println("Values are not inserted...");
		}
		
		ResultSet rs = s.executeQuery("select * from student");
		
		while(rs.next()) {
			System.out.println(rs.getInt("id")+" "+rs.getString("name"));
		}
		
		c.close();
	}

}
