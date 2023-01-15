package collection;

import java.util.ArrayList;
import java.util.ListIterator;

class ArrayListDemo3 {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();

        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);
        list.add(60);
        list.add(70);
        list.add(80);
        list.add(100);
        list.add(3,34);
        list.set(3,150);
        
        System.out.println("For ListIterator Forward : ");
        System.out.print("List = ");

        ListIterator listIterator = list.listIterator(list.size()) ;
       /* while(listIterator.hasNext())
        {
            System.out.print(" "+listIterator.next());
        }

        System.out.println();*/
       

       System.out.println("For ListIterator BackWord : ");
       System.out.print("List = ");

       while(listIterator.hasPrevious())
       {
           System.out.print(" "+listIterator.previous());
       }
       System.out.println();

        
    }
}