package streamapi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamObjects {

	public static void main(String[] args) {
		
		// 1- blank stream ways
		Stream<Object> emptyStream = Stream.empty();
		emptyStream.forEach(e->{
			System.out.println(e);
		});
		
		// 2nd ways
        String[] names = {"Pritam Ray","Omi Verma","Raj Kumar","Chandan Kumar"};
        Stream<String> stream = Stream.of(names);
        stream.forEach(e->{
        	System.out.println(e);
        });
        
        // 3rd ways
        Stream<Object> stream2 = Stream.builder().build();
        
        // 4th ways
        
		IntStream stream3 = Arrays.stream(new int[] { 20, 30, 43, 04, 45, 43, 32 });
		stream3.forEach(e->{
			System.out.println(e);
		});
		
		// 5th ways
	   
		List<Integer> list2 = new ArrayList<Integer>();
		list2.add(10);
		list2.add(70);
		list2.add(94);
		list2.add(61);
		list2.add(73);
		list2.add(220);
		list2.add(31);
		list2.add(60);
		
		Stream<Integer> stream5 = list2.stream();
		stream5.forEach(e->{
			System.out.println(e);
		});
	}
}
