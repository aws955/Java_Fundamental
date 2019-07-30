package java_20190730;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class MapDemo {
	public static void main(String[] args) {
		//생성
		//HashMap 은 key 이 유일해야 하고, value에는 객체를 저장하는데 중복허용
		HashMap<String,Integer> map = new HashMap<String,Integer>();
		
		//할당
		map.put("1", 111111);
		map.put("2", 222222);
		map.put("3", 333333);
		map.put("4", 444444);
		map.put("5", 555555);
		map.put("1", 666666); //키값이 같으면 안들어가는것이 아니라 덮어쓴다.
		
		//출력
		Integer value = map.get("1");
		System.out.println(value);
		
		//set collection 으로 map의 모든 Key 를 받아온다.
		//set 은 객체의 중복을 허용하지않는다.
		//HashMap => Hash Map의 key 를 set 에 담기 => Iterator 로 출력
		Set<String> set = map.keySet();
		
		Iterator<String> i =set.iterator();
		while(i.hasNext()) {
			String k = i.next();
			Integer v = map.get(k);
			System.out.printf("key : %s , value : %d%n",k,v);
		}
	}
}
