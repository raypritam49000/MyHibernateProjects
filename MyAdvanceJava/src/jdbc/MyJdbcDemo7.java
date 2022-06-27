package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class MyJdbcDemo7 {

	public static void main(String[] args) 
	{   
		 PreparedStatement pst= null;
		Connection connection = null;
		String name=null,city=null;
		int id,age;
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/learn","root","0003pray");
			pst = connection.prepareStatement("insert into student values(?,?,?,?)");
			Scanner sc = new Scanner(System.in);
			while(true) 
			  {
				  System.out.println("Enter Id : ");
				  id = sc.nextInt();
				  
				  System.out.println("Enter Name : ");
				  name = sc.nextLine();
				  name = sc.next();
				  
				  System.out.println("Enter City : ");
				   city = sc.nextLine();
				   city = sc.next();
				  
				  System.out.println("Enter Age : ");
				  age = sc.nextInt();
				  
				  //int value = st.executeUpdate("insert into student values("+id+",'"+name+"','"+city+"','"+age+"')");
				   pst.setInt(1,id);
				   pst.setString(2,name);
				   pst.setString(3,city);
				   pst.setInt(4,age);
				   
				  int value = pst.executeUpdate();
				  
				  if(value>0) 
				  {
					  System.out.println("Vaues are inserted...");
				  }
				  else 
				  {
					  System.out.println("Vaues are not inserted...");
				  }
				  
				 System.out.println("Select any one option");
				 System.out.println("1.Insert the values\n2.Fatching the all values\n3.Exit");
				 System.out.println("Enter the Option : ");
				 int option = sc.nextInt();
				 if(option==1) 
				 {
					 System.out.println("Enter Id : ");
					  id = sc.nextInt();
					  
					  System.out.println("Enter Name : ");
					  name = sc.nextLine();
					  name = sc.next();
					  
					  System.out.println("Enter City : ");
					  city = sc.nextLine();
					         city = sc.next();
					  
					  System.out.println("Enter Age : ");
					  age = sc.nextInt();
					  
					   pst = connection.prepareStatement("insert into student values(?,?,?,?)");
					   pst.setInt(1,id);
					   pst.setString(2,name);
					   pst.setString(3,city);
					   pst.setInt(4,age);
					   
					  value = pst.executeUpdate();
					  
					 
					  if(value>0) 
					  {
						  System.out.println("Vaues are inserted...");
					  }
					  else 
					  {
						  System.out.println("Vaues are not inserted...");
					  } 
					  
					     System.out.println("Select any one option");
						 System.out.println("1.Insert the values\n2.Fatching the all values\n3.Exit");
						 System.out.println("Enter the Option : ");
						 option = sc.nextInt();
				 }
				 if(option==2)
				 {
					ResultSet rs =  pst.executeQuery("select * from student");
					while(rs.next()) 
					{
						System.out.println(rs.getString("id")+" "+rs.getString("name")+" "+rs.getString("city")+" "+rs.getString("age"));
					}
					
					 System.out.println("Select any one option");
					 System.out.println("1.Insert the values\n2.Fatching the all values\n3.Exit");
					 System.out.println("Enter the Option : ");
					 option = sc.nextInt();
				 }
				 
				 if(option==3) 
				 {
					 System.out.println("You can terminated>>>>");
					 break;
				 }
				break; 
			  }
			
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


