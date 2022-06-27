package jdbc;

import java.sql.*;

public class MyJdbcDemo1 {

	public static void main(String[] args) {
		Connection c = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			c = DriverManager.getConnection("jdbc:mysql://localhost:3306/connect", "root", "0003pray");
			Statement s = c.createStatement();
			s.executeUpdate("create table student(id int(11), name varchar(100))");
			int i = s.executeUpdate("insert into student values(20,'Pritam'),(42,'Raj'),(23,'Prem')");

			if (i > 0) {
				System.out.println("Value are insert...");
			} else {
				System.out.println("Value are not insert...");
			}

			ResultSet rs = s.executeQuery("select * from student");
			while (rs.next()) {
				System.out.println(rs.getInt("id") + " " + rs.getString("name"));
			}

		} catch (Exception e) {
			System.out.println(e);
		}

		finally {
			try {
				c.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}

	}

}
