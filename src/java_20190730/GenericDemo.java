package java_20190730;

import java.util.ArrayList;

public class GenericDemo {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		//list.add("4"); 제너릭을 선언해주면 오류를 내준다.
		
		for(int i = 0;i<list.size();i++) {
			Integer temp = list.get(i); //(Integer)list.get(i); 에서 (Integer) 를 생략할 수 있다.
			System.out.println(temp);
		}
		
		//enhanced for loop 가능 => ArrayList 가능 (제너릭을 꼭 설정해줘야한다)
		for (Integer integer : list) {
			System.out.println(integer);
		}
		
		//crud 프로그램
		//Create(생성), Read(읽기, 또는 Retrieve 인출), Update(갱신), Delete(삭제, 또는 Destroy 파괴)
	}
}	
