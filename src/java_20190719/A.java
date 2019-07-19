package java_20190719;
//public은 파일이름(확장자를 뺀)과 동일한 클래스에만 추가할 수 있음
public class A {
	String name;
	int age;
	
	public void m() {
		System.out.println("m() 메서드");
	}
	
	public static void main(String[] args) {
		A a = new A();
		a.name = "성영한";
		a.age = 20;
		
		System.out.println(a.name);
		System.out.println(a.age);
		
		a.m();
	}

}

//하나의 파일에는 class 를 하나만 쓰는 것이 관례이다.
//이 파일에서만 사용하는 class 라면 괜찮다.
//main 메서드가 실행되기 위해서는 public이 추가된 클래스에서만 작동됨(두개 이상 있을때만)
class B{
	public static void main(String[] args) {
		System.out.println("hello");
	}
	
}
