package collecationdemo;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class PropertiesDemo3 {

	public static void main(String[] args) {
		 
		try 
		{
			Properties p = new Properties();
			
			p.setProperty("username","Pritam Ray");
			p.setProperty("password","1234");
			
			FileWriter file = new FileWriter("info.properties");
			p.store(file,"Infomation");
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
       System.out.println("Properties Files are Created Successful"); 
		
	}

}
