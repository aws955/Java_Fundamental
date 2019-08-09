package homework2;

public class ChildDemo {
	
	//아직 메모리에 할당되기전이다. 
	//main 메서드가 실행이 되어야 static 에 관련된 변수와 메서드를 메모리에 할당하기 시작한다.
	//Child.staticChild = 2;
	
	static {
		System.out.println("ChildDemo static 초기화");
	}
	
	//VariableDeclarators 변수 선언자 => 해당 에러는 값을 입력해주거나 출력등 매개변수 안에 들어가야 해결
	//값이 존재하는 것은 p.name 등으로 못쓴다.
	public void test() {
		Parent.staticParent=20;
		Parent.staticParentMethod();
		Child.staticChild = 2;
		Child.staticChildMethod();
	}
	
	
	public static void main(String[] args) {
		System.out.println("Main");
		
		/*1
		Parent.staticParentMethod();
		Parent p = new Parent();
		p.parentMethod();
		*/
		
		/*
		Child.staticParentMethod();
		Child.staticChildMethod();
		Child c = new Child();
		c.parentMethod();
		c.childMethod();
		*/
		
		/*
		Parent p = new Parent();
		//System.out.println(p.PI);
		
		Child c = new Child();
		//System.out.println(p.PI);
		System.out.println(c.PI);
		
		Parent p1 = new Child();
		//System.out.println(p1.PI);
		
		Parent p2 = new Child();
		Child c1 = (Child)p2;
		System.out.println(c1.PI);
		*/
	}
}
