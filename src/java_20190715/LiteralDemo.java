package java_20190715;

public class LiteralDemo {
	public static void main(String[] args) {
		// byte 범위를 넘어가면 컴파일 에러 발생
		// 가장 좋은 방법은 더 큰 자료형을 입력하는 것. 캐스팅은 좋지않음
		// byte a1 = 128; <= 컴파일 에러
		// 정수형은 8진수 16진수가 가능하다
		int a1 = 128; // 10진수 표기법
		int a2 = 076; // 8진수 표기법
		int a3 = 0x123; // 16진수 표기법
		System.out.println(a1);
		System.out.println(a2);
		System.out.println(a3);

		// long 리터럴은 숫자뒤에 l, L을 표기함.
		// int 이하 범위내의 숫자를 입력했을 때에는 l이나 L을 뒤에 붙이지 않아도
		// 오토캐스팅이 되어 들어가진다.
		// int 이하 범위 내의 숫자에 l 이나 L 을 붙이게 되면 long 형식(8바이트)가 된다.
		long a4 = 2200000000l;

		// float 리터럴은 소수점 뒤에 f,F로 표기함
		float f1 = 1234.43f;
		// double 리터럴은 소수점 뒤에 d,D로 표기, 생략가능
		double d1 = 1234.43;

		// boolean 리터럴은 true, false
		boolean isExisted = false;

		a1 = 10;
		d1 = 10.0d;
		// primitive data type의 == 연산자는 값만 비교함.
		System.out.println(a1 == d1); // true 가 나옴

		int b1 = 10;
		// b2에 b1의 값인 10을 할당
		int b2 = b1; // b1 의 값인 10을 b2 에 넣어주는 개념이다
		b2 = 20; // primitive 는 값이 들어가기에 참조가 불가능.
					// b2에는 20이 들어가게 되고 b1 에는 영향이 없다.
		System.out.println(b1);
		System.out.println(b2);

	}

}
