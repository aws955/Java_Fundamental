package java_20190725;

public class SubDemo {
	public static void main(String[] args) {
		Sub s1 = new Sub();
		s1.makeMoney(); //부모의 메서드
		s1.gotoSchool();
		s1.play("starcraft"); //부모의 메서드를 overriding(재정의)
		
		s1.money = 1000000;
		s1.chicken = "교촌치킨2마리";
		
		//부모의 멤버변수, 메서드 접근 가능
		//자식의 멤버변수 접근 불가, 메서드 중 오버라이딩 된 메서드만 접근가능
		Super s2 = new Sub(); //reference 타입(ex.Super) 과 객체(ex.Sub)의 타입이 달라진다. (객체의 형변환)
		s2.makeMoney(); 
		//s2.gotoSchool();
		s2.play("starcraft"); 
		
		s2.money = 1000000;
		//s2.chicken = "교촌치킨2마리";
	}
}