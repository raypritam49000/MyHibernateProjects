package collection;

import java.util.LinkedList;
import java.util.Iterator;
import java.util.ListIterator;

public class LinkListDemo {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        LinkedList list1= new LinkedList();

        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);
        list.add(60);
        list.add(70);
        list.add(10);
        list.add(70);


        System.out.println("Linked List = "+list);
        System.out.println("Linked List is empty = "+list.isEmpty());
        System.out.println("Size = "+list.size());
        System.out.println("Result = "+list.contains(56));
        System.out.println(""+list.element());
        System.out.println("Index Value = "+list.get(0));
        System.out.println("Index = "+list.indexOf(70));
        System.out.println("First Index = "+list.lastIndexOf(10));
    
        list1.addAll(list);
        System.out.println("Result = "+list1.containsAll(list));

        System.out.println("List1 = "+list1);

        System.out.println("Result = "+list.equals(list1));

        Object str = list.getFirst();
        System.out.println("First Value = "+str);

        Object str1 = list.getLast();
        System.out.println("Last Value = "+str1);

        Object value  = list.clone();
        System.out.println("LinkedList = "+value);

        System.out.print("LinkedList = ");
        Iterator iterator = list.iterator();
        while (iterator.hasNext()){
          System.out.print(" "+iterator.next());
        }
        System.out.println();

        System.out.print("LinledList = ");
        ListIterator listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            System.out.print(" "+listIterator.next());
        }

        System.out.println();
        System.out.print("LinledList = ");
        while (listIterator.hasPrevious()) {
            System.out.print(" "+listIterator.previous());
        }
 
        System.out.println("Combine List :- ");
        list.addAll(2, list1);
        System.out.println(list);

        System.out.println("Retain All :- ");
        list.retainAll(list1);
        System.out.println(list);

        System.out.println("Remove :- ");
        list.remove(1);
        System.out.println(list);

        list1.clear();
        System.out.println(list1);

        list.removeAll(list1);
        System.out.println(list);

        System.out.print("List = ");
        Iterator descendingIterator = list.descendingIterator();
        while(descendingIterator.hasNext()){
           System.out.print(" "+descendingIterator.next());
        }

        System.out.println();
        list.addFirst(200);
        list.addLast(400);
        System.out.println("List = "+list);

       Object removeFirst = list.poll();
       System.out.println("Remove Element = "+removeFirst);
       System.out.println("List = "+list);

       list.pollFirst();
       list.pollLast();
       System.out.println("List = "+list);

       list.removeFirstOccurrence(30);
       list.removeLastOccurrence(10);
       System.out.println("List = "+list);

       list.offer(100);
       System.out.println("List = "+list);

       list.offer(200);
       System.out.println("List = "+list);

       list.offerFirst(130);
       System.out.println("List = "+list);

       list.offerLast(150);
       System.out.println("List = "+list);
      
       System.out.println("First Element= "+list.peek());
       System.out.println("First Element= "+list.peekFirst());
       System.out.println("Last Element= "+list.peekLast());



    } 
    
}
