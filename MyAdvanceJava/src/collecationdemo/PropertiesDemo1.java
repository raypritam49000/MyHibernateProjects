package collecationdemo;

import java.io.FileReader;
import java.util.Properties;

public class PropertiesDemo1 {

	public static void main(String[] args)  {
		
	    try {
		
		FileReader reader = new FileReader(System.getProperty("user.dir")+"//src//collectiondemo//confi.properties");
		
		Properties p = new Properties();
		p.load(reader);
		
		System.out.println("UserName : "+p.getProperty("user"));
		
		System.out.println("Password : "+ p.getProperty("password"));
	  }
	  catch(Exception e) {
		
	  }
    
	}

}
