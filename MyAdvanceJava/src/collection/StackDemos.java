package collection;

import java.util.Stack;

public class StackDemos {

	public static void main(String[] args) {
		Stack st = new Stack();
		
		st.push(19);
		st.push(14);
		st.push(67);
		st.push(512);
		st.push(56);
		st.push(76);
		st.push(89);
		st.push(9);
		
		System.out.println(" "+st);
		
		st.pop();
		st.pop();
		st.pop();
		st.pop();
		
		System.out.println(" "+st);
		
		
				

	}

}
