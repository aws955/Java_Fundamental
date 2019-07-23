package java_20190722;

public class MethodDemo {

	// 메서드를 정의
	// boolean 메서드의 반환값
	// instance 메서드 : 객체마다 생성되는 메서드
	// int year = > 매개변수(parameter)
	public boolean isLeafYear(int year) {
		// 메서드의 반환값이 boolean 이기 때문에 return value 의
		// value도 boolean 이어야 한다.
		return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
	}

	// String msg , int index => 매개변수(parameter)
	public char charofString(String msg, int index) {
		// String msg "hello";
		// 특정문자열의 인덱스를 지정하면 문자 하나만 반환하는 메서드를 만들어 보겠다.
		// String 문자열 관련 명령어 => charAt() 해당 인덱스의 문자를 추출
		return msg.charAt(index);
	}

	public long plus(int first, int second) {
		// 반환값을 int 하게 되면 21억 과 21억이 들어갔을때 circuit 이 발생한다.
		// long 으로 받아줘야 계산이 가능하다. 그래서 보통 plus 같은 경우는 매개변수가 long 이다.
		return (long) first + (long) second;
	}

	// 나누기
	public double divide(double first, double second) {
		return first / second;
	}

	// 메서드가 실행된 이후에 자동으로 배열에 저장되므로 반환값을 지정할 필요가 없다. call by reference
	public void ascending(int[] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length - (i + 1); j++) {
				if (array[j] > array[j + 1]) {
					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
		}
	}

	public static void main(String[] args) {

		MethodDemo m1 = new MethodDemo(); // m1 에 할당을 해주는 이유는 이후에 여러번 사용할 것이기 때문이다.
		// instance 메서드의 사용방법
		// 객체를 생성한 후에 reference 를 이용해서 접근하면 됨 (여기에서 reference 는 m1 이다)
		// 4 , 100 => 전달인자(argument)
		boolean isLeafYear = m1.isLeafYear(4);
		System.out.println(isLeafYear);
		System.out.println(new MethodDemo().isLeafYear(100)); // 이렇게도 가능

		// "hello",0 => 전달인자(argument) (아래의 경우 전달인자가 2개)
		char c = m1.charofString("hello", 0);
		System.out.println(c);

		long sum = m1.plus(2100000000, 2100000000);
		System.out.println(sum);

		double div = m1.divide(3, 8);
		System.out.println(div);

		int[] temp = { 1, 2, 3, 4, 5, 41, 6, 25, 11 };
		for (int a : temp) {
			System.out.print(a + "\t");
		}
		System.out.println();
		m1.ascending(temp);
		for (int a : temp) {
			System.out.print(a + "\t");
		}

	}

}
