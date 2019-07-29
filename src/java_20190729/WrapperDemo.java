package java_20190729;
//ctrl + shift + o => 자동 import 단축키
import java.util.ArrayList;

//프로젝트 선택 후 속성 -> 컴파일러에서 버전 교체
//본 클래스는 1.4로 테스트
public class WrapperDemo {
	public static void main(String[] args) {
		
		//자바 1.4이전 버전에서는 primitive data type을 Collection에 저장 할 수 없었기 때문에
		//primitive data type을 객체화 할 수 있는 Wrapper으로 변환하여 저장해야한다.
		
		//1. primitive data type => wrapper class 로 변환
		//2. String => wrapper class 로 변환
		//3. wrapper class -> primitive data type 으로 변환
		//4. String => primitive data type 으로 변환
		//5. primitive data type => String.valueOf()
		
		//1. primitive data type => wrapper class 로 변환
		//Collection 에서 primitive type 을 받을 방법이 없었다.
		//그래서 WrapperClass 가 생긴것이다.
		ArrayList list = new ArrayList();
		list.add(new Integer(1));
		//WrapperClass 의 생성자를 이용하는것 (5.0 이상부터는 auto-boxing 이 일어나서 그냥 넣어도 된다)
		
		//2. String => wrapper class 로 변환
		//암기 => 문자열 10을 WrapperClass로 바꾸는것
		String s1 = "10";
		Integer i1 = Integer.valueOf(s1);
		//valueof 는 오버라이딩 되어 String 을 wrapper class 로 바꿔주기도 하고
		//primitive 를 wrapper class 로 바꿔준다.
		
		//3. wrapper class -> primitive data type 으로 변환
		Integer i2 = new Integer(10);
		Integer i3 = new Integer(20);
		//만약 WrapperClass 했던걸 계산을 하고 싶다면.
		//int temp = i2 + i3; => 절대 x
		int temp = i2.intValue() + i3.intValue();
		
		//4. String => primitive data type 으로 변환
		//String 으로 된 것은 primitive 로 만들때
		//이것을 제일 많이 쓴다.
		String s3 = "10";
		String s4 = "20";
		int temp1 = Integer.parseInt(s3) + Integer.parseInt(s4);
		
		//5. primitive data type => String.valueOf()
		int a1 = 10;
		String s5 = String.valueOf(a1);
		//모든 primitive data type 에 +"" 을 하게 되면 문자열로 바뀌지만 쓰지말자.
		
		
		//auto-boxing : primitive data type 을 자동으로 wrapper 로 바꿔준다. (5.0 이상)
		Integer i4 = 10; //wrapper class 10이 들어가는 것이다.
		
		//auto-unboxing : wrapper 를 자동으로 primitive data type 으로 만들어 줌
		int a2 = i2 + i3;
		System.out.println(a2);
		
		//Integer 의 API 를 보면 equals() , hashCode() , toString() 메서드가 오버라이딩 되어있다.
		//wrapper 클래스는 가능하다
		//나머지 primitive 타입들은 응용만 하면 된다.
		
	}
}
