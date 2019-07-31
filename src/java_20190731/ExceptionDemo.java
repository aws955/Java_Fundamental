package java_20190731;

import java.util.ArrayList;

public class ExceptionDemo {
	public static void main(String[] args) {
		int i = Integer.parseInt("111");
		System.out.println(i);
		
		//에러 메세지를 보고 어느 부분에서 에러가 났는지 유추하면 좋다.
		//에러가 나면 어느 부분에 문제가 있는지 라인을 출력해준다. 참고하면 좋다.
		//자바에서는 모든 예외처리를 객체로 관리한다.
		//예외를 관리하는 클래스는 java.lang 패키지에 있다.
		//JVM 은 실행중에 예외가 발생하면 묵시적으로 예외 객체를 생성하여 예외를 발생
		//예외 발생의 가장 큰 문제는 그 순간 프로그램이 종료된다.
		
		//NumberFormatException
		//"a" 는 문자열이기 때문에 int 로 바꿀수가 없어 실행시 에러가 난다.
		//예외가 발생하면 실행시 에러가 나고 하단이 실행되지않는다.
		//int i1 = Integer.parseInt("a");
		//System.out.println(i1);
		
		//ArrayIndexOutOfBoundsException
		//배열의 길이를 넘어가는 값을 불러올 시에도 실행시 에러가 난다.
		//int[] a = {1,2,3,4};
		//System.out.println(a[4]);
		
		//IndexOutOfBoundsException
		//컬렉션에서도 컬렉션의 길이를 넘어가는 값을 불러올 시에 에러가난다.
		//ArrayList<Integer> list =new ArrayList<Integer>();
		//list.add(1);
		//list.add(2);
		//System.out.println(list.get(2));
		
		//NullPointerException
		//String 이 null 이라는 이야기는 객체가 아직 생성되지 않았다는 것이다.
		//이런 상태에서 길이를 구하라던가 하는 메서드를 할시에는 실행시 에러가 난다.
		//String str = null;
		//System.out.println(str.length());
		
		//ArithmeticException =>나눌때 분모가 0이 되면 나오는 에러 메세지 
		// 뒤쪽에 /by zero 라고 함께 출력
		//int b= 0;
		//int c = 1;
		//System.out.println(c/b);
	}
}
