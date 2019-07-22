package java_20190719;

//public 은 20190722 패키지에서 staticDemo 를 하기 위해 입력함.

public class Customer {
	public String name;
	public String email;
	public String phone; //전화번호는 문자열이다. 숫자로 둘 시 여러가지 문제가 생길 수 있다.
	public int age; //성별은 값이 2개 일지라도 boolean 으로 선언해서는 안된다.
	public double balance;
	public boolean isReleased;
	public static double interestRate;
	public static final String BANKNAME = "신한은행";  //static 을 빼버리면 객체마다 존재하게 된다.
}
