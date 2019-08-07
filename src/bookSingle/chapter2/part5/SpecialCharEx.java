package bookSingle.chapter2.part5;

public class SpecialCharEx {
	public static void main(String[] args) {
		// 예제에서는 문자인 경우에는 작은 따옴표 , 문자열인 경우에는 큰 따옴표를 나눠서 사용하였다.
		// 특수문자를 사용할때에는 \ (역슬래시) 가 필요하다는 것만 유의해서 보면 될거같다
		// ""(큰따옴표) 안에서는 작은따옴표는 역슬래시 없이 가능하고 ''(작은 따옴표) 안에서는 큰 따옴표가 역슬래시 없이 가능하긴하나
		// 다 역슬래시를 붙여서 표현하는게 편리하다.
		System.out.println('\'');
		System.out.println("abc\t123\b456");
		System.out.println('\n');
		System.out.println("\"Hello\"");
		System.out.println("c:\\");

		// 대부분 println() 메서드를 통해서 개행을 진행한다.
		// \n 과 \r 중에 굳이 사용한다면 \n을 더 많이 사용하지만 \n만으로 개행이 인식 안되는 파일을 열 때 \r을 같이 쓴다.
		System.out.print("abcde\n");
		System.out.print("abcde\r");
		System.out.print("abcde\r\n");
		System.out.print("end");
	}
}
