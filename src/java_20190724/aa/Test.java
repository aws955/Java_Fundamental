package java_20190724.aa;

class Test {
	Test(){}
	
	/* single turn   객체를 하나만 만들 때 사용.
	public static Test t;
	private Test() {}
	public static Test getInstance() {
		if(t == null) {
			t = new Test();
		}
		return t;
	}
	*/
	
	//compiler 는 클래스 내에 생성자가 없으면 자동으로 디폴트 생성자를 만들어 준다. 
	//이때 생성자의 접근 한정자는 클래스의 접근한정자와 동일하게 만들어 준다.
	// public class Test => public Test(){}
	// class Test => Test(){}

}

class Test1{
	//한 파일에 여러 클래스를 만들 수 있다.
	//public 은 한 파일에 하나의 클래스에만 사용가능
	//나머지 파일들은 default 클래스가 되어서 같은 패키지 내에서만 가능
	//결국 Test1 클래스를 다른 패키지에서도 사용하고 싶다면 별도의 파일을 생성하여 접근 한정자를 public 으로 해줘야한다.
	
	//main 메서드는 확장자를 뺀 파일 이름과 동일한 클래스에서만 사용이 가능하다.
	//Test에서는 가능하지만 Test1 에서는 실행되지 않는다.
}
