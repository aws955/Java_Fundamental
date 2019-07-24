package java_20190724;

public class Box {
	int width;
	int height;
	int depth;
	
	//final 변수는 멤버변수 위치에서 초기화해야 함.
	//한번 정해지면 변경 불가
	//instance 로 만들면 객체마다 들어가있게 된다. (메모리상으로 말도 안되는 이야기)
	//final 변수명은 대문자로 하는 것이 관례
	static final String NAME = "BOX";
	
	public void change (Box b) {
		b.depth = 3000;
		
		
		//매개변수도 지역 변수이다
		//메서드내에서 매개변수를 포함한 사용자가 정의한 변수를 지역변수라고 한다.
		//지역변수는 자동으로 초기화 되지 않기 때문에 기본값을 저장하고 사용한다.
		//지역변수의 유효범위는 메서드 내에서만 사용가능
		
		/*
		int test;
		System.out.println(test); //지역변수는 자동으로 초기화 되지 않는다. (오류 o)
		System.out.println(width); //멤버변수는 자동으로 초기화 되어 0 을 가지고 있다. (오류 x)
		*/
		
		/*
		지역변수의 초기화
		int a = 0;
		String srt = null;
		double d = 0.0;
		*/
	}
}
