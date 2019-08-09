package homework2;

public class Parent extends Object {
	String name;
	static int staticParent;
	
	public Parent() {
		super();
		System.out.println("Parent 생성자");
	}
	
	static {
		staticParent = 20;
		System.out.println("Parent static 초기화");
	}
	
	{
		System.out.println("Parent instance block");
	}
	
	
	public void parentMethod() {
		System.out.println("parentMethod");
	}
	
	public static void staticParentMethod() {
		System.out.println("staticParentMethod");
	}
	
	
	
	
}
