package java_20190719;

public class Customer {
	String name;
	String email;
	String phone; //전화번호는 문자열이다. 숫자로 둘 시 여러가지 문제가 생길 수 있다.
	int age; //성별은 값이 2개 일지라도 boolean 으로 선언해서는 안된다.
	double balance;
	boolean isReleased;
}
