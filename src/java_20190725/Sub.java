package java_20190725;

public class Sub extends Super {
	String chicken;
	
	public void gotoSchool() {
		System.out.println("Sub gotoSchool");
	}

	// overriding : 부모의 메서드를 재정의 (play1 로 새로 만들 필요가 없다)
	// 1. 반환형, 메서드 이름, 매개변수 일치
	// 2. 접근 한정자는 부모보다 자식이 상위이거나 같으면 됨.   public > protected > default
	// private 는 안됨
	
	public void play(String starcraft) {
		// super.play("omok"); //super. => 부모의 객체 //부모의 기능 + 추가된 기능을 사용하고 싶을때
		System.out.println("Sub play()");
	}
}
