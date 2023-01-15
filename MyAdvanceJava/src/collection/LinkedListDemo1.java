package collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;
import java.util.Vector;

public class LinkedListDemo1 {

	public static void main(String[] args) {
		
		LinkedList list = new LinkedList();
		//ArrayList  list = new ArrayList();
		
		MyTimer.startTime();
		for(int i=0; i<=10000; i++) {
			list.add(i);
		}
		MyTimer.endTime();
		
		
		MyTimer.startTime();
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
		MyTimer.endTime();
		
		
		
		
	}}