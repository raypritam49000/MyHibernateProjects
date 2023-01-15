package collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ArrayListDemo2 {

	public static void main(String[] args) {
		
		String[] name = {"Pritam Ray","Omi Verma","RajniKant","Surya Don","Shamroz Khan"};
		
		ArrayList<String> namelist = new ArrayList<String>(Arrays.asList(name));
		
		System.out.print("Name List = "+namelist);
		System.out.println();
		
		Collections.sort(namelist);
		System.out.println("Increments Order = "+namelist);
		
		Collections.sort(namelist,Collections.reverseOrder());
		System.out.println("Decremets Order = "+namelist);

	}

}
