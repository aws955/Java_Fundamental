package java_20190723;

public class AdminDemo {
	public static void main(String[] args) {

		Admin a = new Admin("syh1011", "1234", "syh@hbilab.org",1); // 멤버변수의 값들이 초기화 됐음 , (null,null,null,0)
		// a.setId("syh1011");
		// a.setPwd("1234");
		// a.setEmail("syh@hbilab.org");
		// a.setLevel(1);
		
		Admin a1 = new Admin();

		System.out.printf("%s,%s,%s,%d %n", a.getId(), a.getPwd(), a.getEmail(), a.getLevel());
	}

}
