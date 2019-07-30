package java_20190730;

import java.util.Iterator;
import java.util.TreeSet;

public class SetDemo {
	public static void main(String[] args) {
		// 자동 import : ctrl + shift + o(영문자)
		// HashSet은 데이터(객체)의 중복을 허용하지 않고, 순서가 없음
		// HashSet set = new HashSet();//선언
		TreeSet<Integer> set = new TreeSet<Integer>(); // Hashset을 하지않고 TreeSet을 하게 되면 오름차순이 된다.

		// collection 에 넣을 때에는 객체 형식만 들어갈 수 있다.
		// primitive data type 을 입력하게 되면 wrapper class 형식으로 들어간다. (auto-boxing 발생)
		// 위의 경우에는 int 가 들어가는게 아니라 Integer 로 들어가게 되는것이다.
		// HashSet에서는 set을 해줄때 equals() 와 hashCode() 를 이용해서 중복을 검사하게 된다. 
		// (wrapper class의 경우에는 overriding이 되어 있지만 객체를 넣을 때는 overriding 을 해줘야한다)
		// set.size() 를 이용하여 HashSet의 길이를 알 수 있다.
		while (true) {
			int random = (int) (Math.random() * 45) + 1;
			set.add(random); // 할당 , set.add()
			if (set.size() == 6)
				break;
		}

		// HashSet의 출력은 Iterator(반복자) 를 이용해서 출력해야한다.
		Iterator<Integer> i = set.iterator();
		while (i.hasNext()) { // hasNext() : HashSet에 출력할 객체가 존재하는지를 판단하는 메서드
			// auto-unboxing : Integer 가 int temp 에 들어갈 수 없다. 자동으로 wrapper class를 primitive
			// 로 변환했기에 가능한것
			int temp =  i.next(); // next() 해당 객체를 가져오는 메서드
			//next() 가 반환타입이 Object 이기 때문에 형변환을 해준다.
			System.out.print(temp + " ");
		}
		
	}
}
