package java_20190724;

//i18n => 국제화 (Internationalization)
//I nternationalizatio n => 가운데가 18글자라서 생략

//l10n => 지역화(localization)
//l ocalizatio n => 가운데가 10글자라서 생략

//static 초기화 블럭  -> main -> instance 초기화 블럭 ->생성자
public class InitializationDemo {
	

	// static 초기화 블럭 => main 함수보다 먼저 실행이 된다.
	static {
		System.out.println("static area");
		b = 100;
	}

	
	//instance 초기화 블럭 (이런식으로 선언하게 되면 모든 객체의 a의 default가 10이 된다.)
	{
		System.out.println("instance area");
		a=10;
	}
	// 생성자에서 초기화할 수 있는 변수는 instance 변수만 가능
	public InitializationDemo(int a) {
		System.out.println("생성자");
		this.a=a;
	}
	
	int a;
	static int b;
	static final int C = 10;

	public static void main(String[] args) {
		System.out.println("main area");
		InitializationDemo i = new InitializationDemo(1000);
		System.out.println(i.a);
		System.out.println(b);
		System.out.println(C);
	}
}
