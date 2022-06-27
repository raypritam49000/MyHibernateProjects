package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ClientTest 
{

	public static void main(String[] args) 
	
	{   
		String SQL = "select * from student";
		
	  try(Connection connection = DBUtil.getConnection();
			  PreparedStatement pst = connection.prepareStatement(SQL,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE))
	   {
		  ResultSet rs = pst.executeQuery();
		  
		  rs.absolute(1);
		  int rowNum1 = rs.getRow();
		  System.out.println("Row Num1 : "+rowNum1);
		  
		  rs.afterLast();
		  Boolean result1 = rs.isAfterLast();
		  System.out.println("AfterLast : "+result1);
		  
		  rs.beforeFirst();
		  Boolean result2 = rs.isBeforeFirst();
		  System.out.println("BeforeFirst : "+result2);
		  
		  rs.first();
		  Boolean result3 = rs.isFirst();
		  System.out.println("First : "+result3);
		  
		  rs.last();
		  Boolean result4 = rs.isLast();
		  System.out.println("Last : "+result4);
		  
		  rs.relative(-3);
		  int rowNum2 = rs.getRow();
		  System.out.println("Row Num2 : "+rowNum2);
	  
	  }
	  
	  catch (Exception e) 
	  {
		System.out.println(e);
	  }
    
	}

}
