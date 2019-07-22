package java_20190722;

import java_20190719.Customer; //다른 패키지에 있는 클래스를 불러오는 명령어

public class CustomerStaticDemo {
	public static void main(String[] args) {

		// c1.interestRate 라고 표현해도 되지만 클래스 이름으로 선언하는 것이 좋다.
		// Customer 내의 모든 객체가 공유하는 변수임을 쉽게 알 수 있다
		// 보통 가장 상단에 쓴다.
		Customer.interestRate = 3.5;

		Customer c1 = new Customer();
		c1.name = "홍길동";
		c1.age = 40;
		c1.email = "kdhong@test.com";
		c1.phone = "010-8080-0987";
		c1.balance = 190000.43;
		c1.isReleased = false;

		// final 변수는 재할달 할 수 없음
		// Customer.BANKNAME = "국민은행';
		// static 변수는 클래스 이름으로 접근하는 것이 관례이지만 reference로도
		// 접근이 가능하다(권장하지 않음)
		// c1.interestRate = 3.5;

		Customer c2 = new Customer();
		c2.name = "아무개";
		c2.age = 50;
		c2.email = "noname@test.com";
		c2.phone = "010-2345-9876";
		c2.balance = 3500000.45;
		c2.isReleased = false;

		Customer c3 = new Customer();
		c3.name = "배조스";
		c3.age = 62;
		c3.email = "jaws@amazon.com";
		c3.phone = "010-1111-1111";
		c3.balance = 12000000000.45;
		c3.isReleased = true;
	}

}
