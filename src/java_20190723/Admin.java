package java_20190723;

//private 를 선언하는 이유는 외부에서 멤버변수들을 접근하여 수정을 하게되면 메서드들이 조작될 수가 있다.

public class Admin {
	private String id;
	private String pwd;
	private String email;
	private int level;

	// 디폴트 생성자(default constructor) => Alt + Shift + s => c
	// 이 부분이 주석 처리되면 Demo에서 디폴트 생성자로 객체를 만들 수 없다.
	// 생성자가 하나라도 있다면 compiler 가 자동으로 디폴트 생성자를 만들어 주지 않기때문이다.
	// 인스턴스 변수 선언 후 디폴트 생성자 + 모든 인스턴스를 초기화 하는 생성자 를 만들어 놓고 시작하는게 깔끔하다
	public Admin() {
		super(); // 모든 생성자에는 super 가 숨어져있다. 부모클래스의 default 생성자를 호출해준다.
	}

	// 생성자(constructor) => Alt + Shift + s => o
	// 생성자는 반환값이 없고, 이름은 클래스 이름과 동일하게
	// 역할은 인스턴스 변수 초기화(값을 처음으로 할당)
	public Admin(String id, String pwd, String email, int level) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.email = email;
		this.level = level;
	}

	// 생성자의 오버로딩
	public Admin(String id, String pwd, String email) {
		// this.id = id;
		// this.pwd = pwd;
		// this.email = email;
		this(id, pwd, email, 0); // 다른 생성자 호출 (처음에 모든 인스턴스를 초기화 하는 생성자를 생성하고 그 다음부터는 this 를 이용한다.
		// this 로 호출하는 경우 super() 가 없다.
		// this 용법 2가지
		// 1. 자기자신 객체 =>this.
		// 2. 다른 생성자 호출 => this(~~) ,생성자에서만 사용가능
	}

	// instance 변수의 setter, getter 생성 방법
	// Alt + shift + s => r => tab => enter => tab*4 => enter
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

}
