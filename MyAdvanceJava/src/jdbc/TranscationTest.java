package jdbc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class TranscationTest {

	public static void main(String[] args) 
	{
		Connection con = null;
		try 
		{
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/learn","root","0003pray");
			con.setAutoCommit(false);
			
			PreparedStatement pst1 = con.prepareStatement("update account set e_bal = e_bal+? where e_id = ?");
			
			PreparedStatement pst2 = con.prepareStatement("update account set e_bal = e_bal-? where e_id = ?");
			
			System.out.print("Enter from Account Id : ");
			int f_id = Integer.parseInt(br.readLine());
			
			System.out.print("Enter to Account Id : ");
			int t_id = Integer.parseInt(br.readLine());
			
			System.out.print("Enter the Amount :");
			int amt = Integer.parseInt(br.readLine());
			
			PreparedStatement pst = con.prepareStatement("select e_bal from account where e_id ="+f_id);
			
			ResultSet rs = pst.executeQuery();
			//System.out.println(rs);
			
			int avlAmt = 0;
			
			if(rs.next())
			{
			 avlAmt = rs.getInt("e_bal");
			}
			
			if(avlAmt>=amt)
			{
			pst1.setInt(1,amt);
			pst1.setInt(2,t_id);
			pst1.executeUpdate();
			
			//int i=4/0;
			
			pst2.setInt(1,amt);
			pst2.setInt(2,f_id);
            pst2.executeUpdate();
            
			con.commit();
			System.out.println("Transaction are sucessfull...");
			}
			else
			{
			System.out.println("U do not hv sufficient bal...");
			}
			
		} 
		catch (Exception e) 
		{    
			try
			{
			System.out.println(e);
			System.out.println("Rollingback....");
			con.rollback();
            }
			catch(Exception e1)
			{
				System.out.println(e1);
			}
			System.out.println(e);
		}
		finally 
		{
			try 
			{
				con.close();
			} 
			catch (Exception e2) 
			{
				System.out.println(e2);
			}
		}
		
			
		
	}

}
