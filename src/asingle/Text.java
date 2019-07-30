package asingle;

import java.util.Iterator;
import java.util.TreeSet;

//set 이용하여 lotto 만들기
public class Text {
	public static void main(String[] args) {
		//HashSet 과 TreeSet 을 했었다.
		//TreeSet 은 오름차순 정렬을 알아서 해준다.
		//TreeSet 과 HashSet의 사용법은 거의 동일하다.
		
		//<> 제너릭 : 선언해주면 데이터의 안정성이 보장된다.
		//생성
		TreeSet<Integer> c = new TreeSet<Integer>();
		
		//할당
		while(true) {
			int random = (int)(Math.random()*45)+1;
			c.add(random); 
			//오토 박싱이 일어난 것이다.
			//int 는 들어갈 수 없다.
			if(c.size()==6) break;
		}
		
		
		Iterator<Integer> i = c.iterator();
		while(i.hasNext()) {
			int temp = i.next();
			System.out.print(temp+ " ");
		}
		
		
	}
}
