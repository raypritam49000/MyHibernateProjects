package jdbc;

import java.sql.*;
import java.io.*;

public class RetrieveImage
{
public static void main(String[] args)
{
try
{
Class.forName("com.mysql.cj.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/learn","root","0003pray");
PreparedStatement ps=con.prepareStatement("select * from imagtable");

ResultSet rs = ps.executeQuery();
rs.next();//now on 1st row

Blob b = rs.getBlob(2);
byte barr[] = new byte[(int)b.length()];//an array is created but contains no data
barr = b.getBytes(1,(int)b.length());

FileOutputStream fout=new FileOutputStream("C:\\Users\\AndroTech 4u\\Downloads\\Video\\ReturnBook.png");
fout.write(barr);

fout.close();
System.out.println("ok");
con.close();
}catch (Exception e) 
{
	e.printStackTrace();
}
}
}
