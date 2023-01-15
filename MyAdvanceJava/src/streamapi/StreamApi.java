package streamapi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamApi {

	public static void main(String[] args) {
		List<Integer> list1 = Arrays.asList(10, 90, 50, 43, 61, 84, 93, 50, 70, 99);
		System.out.println(list1);

		List<Integer> list2 = new ArrayList<Integer>();
		list2.add(10);
		list2.add(70);
		list2.add(94);
		list2.add(61);
		list2.add(73);
		list2.add(220);
		list2.add(31);
		list2.add(60);
		System.out.println(list2);

		// without stream api
		ArrayList<Integer> listEven = new ArrayList<>();

		for (Integer i : list2) {
			if (i % 2 == 0) {
				listEven.add(i);
			}
		}
		System.out.println(list2);
		System.out.println(listEven);

		// using stream api
		Stream<Integer> stream = list2.stream();
		List<Integer> newList = stream.filter(i -> i % 2 == 0).collect(Collectors.toList());
		System.out.println(newList);

		List<Integer> newList2 = list1.stream().filter(i -> i % 2 == 0).collect(Collectors.toList());
		System.out.println(newList2);

		List<Integer> newList3 = list1.stream().filter(i -> i > 70).collect(Collectors.toList());
		System.out.println(newList3);

		List<Integer> list3 = Arrays.asList(10, 90, 50, 43, 61, 84, 93, 50, 70, 99);
		List<Integer> list4 = list3.stream().map(i -> i * i).collect(Collectors.toList());
		System.out.println(list4);

		System.out.println("For Each Method1");
		list3.stream().forEach(e -> {
			System.out.println(e);
		});
		
		System.out.println("For Each Method2");
		list3.stream().forEach(System.out::println);
		
		System.out.println("For Sorted Method");
		list3.stream().sorted().forEach(System.out::println);
		
		System.out.println("For Max Method2");
		Integer integer = list3.stream().max((x,y)->x.compareTo(y)).get();
		System.out.println(integer);
		
		System.out.println("For Min Method2");
		Integer integer2 = list3.stream().min((x,y)->x.compareTo(y)).get();
		System.out.println(integer2);
	}

}
