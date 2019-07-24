package java_20190724;

public class EmployeeDemo {
	public static void main(String[] args) {
		Employee e1 = new Employee();
		e1.name = "성영한";
		e1.phone1 = "010";
		e1.phone2 = "2033";
		e1.phone3 = "1909";
		//여기까지는 Employee 에 없지만 Customer 에서 상속받아서 
		//자신의 것처럼 만들 수 있다.
		//만약 Customer에서 private 를 선언한 변수나 메서드는
		//상속되지가 않는다.
		
		
		e1.zipcode = "12345";
		e1.address1 = "서울";
		e1.address2 = "제2 롯데 110층 1021호";
		e1.id = "syh1011";
		e1.pwd = "1234";
	}
}
