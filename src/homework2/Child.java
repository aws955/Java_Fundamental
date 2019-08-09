package homework2;

public class Child extends Parent {
	public static final double PI = 3.14;
	static int staticChild;
	String phone;
	
	public Child() {
		super();
		System.out.println("Child 생성자");
	}
	
	static {
		staticChild = 200;
		System.out.println("Child static 초기화");
	}

	{
		System.out.println("Child instance block");
	}
	
	public void childMethod() {
		System.out.println("childMethod");
	}
	
	public static void staticChildMethod() {
		System.out.println("staticChildMethod");
	}
	
}
