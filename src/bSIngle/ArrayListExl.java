package bSIngle;

import java.util.*;

public class ArrayListExl {
	static void print(ArrayList list1,ArrayList list2) {
		System.out.println("list1:"+list1);
		System.out.println("list2:"+list2);
		System.out.println();
	}
	public static void main(String[] args) {
		
		//list1 이라는 ArrayList 를 만든다.
		//5, 4, 2, 0, 1, 3
		//list2 라는 새로운 ArrayList를 만들고
		//list1의 1~4까지의 값을 복사한다.
		System.out.println("list1이라는 ArrayList 를 만들고 값을 할당. list2 는 list1 에서 1~4 까지 값을 할당");
		ArrayList list1 = new ArrayList();
		list1.add(new Integer(5));
		list1.add(new Integer(4));
		list1.add(new Integer(2));
		list1.add(new Integer(0));
		list1.add(new Integer(1));
		list1.add(new Integer(3));
		ArrayList list2 = new ArrayList(list1.subList(1, 4));
		print(list1,list2);
		
		
		//Collections.sort => 정렬하는 것
		System.out.println("Collection.sort() 라는 메서드를 이용해서 list1 과  list2 를 정렬");
		Collections.sort(list1);
		Collections.sort(list2);
		print(list1,list2);
		
		System.out.println("containsAll() 이라는 메서드는 매개변수의 모든 요소를 포함하고 있을 때만 true");
		System.out.println("list1.containsAll(list2):"+list1.containsAll(list2));
		
		System.out.println();
		
		System.out.println("add() 를 이용해 새로운 객체를 넣어준다.");
		System.out.println("3 이라는 인덱스를 이용하여 중간에 값을 끼워넣는것도 가능");
		list2.add("B");
		list2.add("C");
		list2.add(3,"A");
		print(list1,list2);
		
		System.out.println("set() 을 이용하면 해당 인덱스의 값을 변화 시켜줌");
		list2.set(3, "AA");
		print(list1,list2);
		
		
		System.out.println("retainAll() 은 매개변수의 요소와 공통된 것만 남기고 remove");
		System.out.println("list1.retainAll(list2): "+list1.retainAll(list2));
		print(list1,list2);
		
		
		for(int i = list2.size()-1;i>=0;i--) {
			if(list1.contains(list2.get(i)))
				list2.remove(i);
		}
		print(list1,list2);
	}
}
