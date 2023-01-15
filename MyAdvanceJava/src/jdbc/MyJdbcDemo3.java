package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class MyJdbcDemo3 {

	public static void main(String[] args) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/connect","root","0003pray");
		System.out.println(c);
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Id");
		int id = sc.nextInt();
		
		System.out.println("Enter Name");
		String name = sc.next();
		
		PreparedStatement ps = c.prepareStatement("insert into student values(?,?)");
		ps.setInt(1,id);
		ps.setString(2,name);
		int i = ps.executeUpdate();
		
		if(i>0) {
			System.out.println("Value are inserted...");
		}
		else {
			System.out.println("Value are not inserted...");
		}
		
		ResultSet rs = ps.executeQuery("select * from student");
		
		while(rs.next()) {
			System.out.println(rs.getInt("id")+" "+rs.getString("name"));
		}

	}

}
