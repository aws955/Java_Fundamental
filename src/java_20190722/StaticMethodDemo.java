package java_20190722;

public class StaticMethodDemo {
	String name; // instance 변수
	static double interestRate; // static 변수

	public void m1() {
		System.out.println("m1() 메서드 포출");
	}

	public void m2() {
		// instance method 에서는 instance 변수, static 변수 사용 가능
		// instance method, static method 호출 가능
		this.name = "성영한"; // instance 변수
		StaticMethodDemo.interestRate = 0.1; // static 변수
		this.m1(); // instance 메서드
		StaticMethodDemo.m3(); // static 메서드

		// 클래스 내에서 사용했기 때문에 this 와 클래스 명은 생략가능하다.
	}

	public static void m3() {
		System.out.println("m3() 메서드 포출");

	}

	public static void m4() {
		// static method 에서는 instance 변수 사용 불가 , static 변수 사용 가능
		// instance method 호출 불가능 , static method 호출 가능
		// name = "홍길동";
		interestRate = 0.2;
		// m1();
		m3();

		// static method에서는 this 를 사용할 수 없다.
		// 같은 클래스 내에서 썼기때문에 클래스명은 생략 가능하다.

	}

	public static void main(String[] args) {
		StaticMethodDemo.m3(); // Class명.m3 이 맞다.
		StaticMethodDemo.m4();
		StaticMethodDemo.interestRate = 1.4;

		// instance 변수와 method 는 객체가 생성되어야만 메모리에 올라간다.
		// 아래와 같이 객체를 만들어야만 가능하다.
		StaticMethodDemo s1 = new StaticMethodDemo();
		s1.m1();
		s1.m2();
		s1.name = "alkdjfp";
	}
}
