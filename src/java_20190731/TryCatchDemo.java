package java_20190731;

public class TryCatchDemo {
	public static double getAvg(int korean, int english) {
		int sum = korean + english;
		double avg = (double) sum / (double) 2;
		return avg;
	}

	public static void main(String[] args) {
		//그냥 실행하면 ArrayIndexOutOfBoundsException 예외 발생
		//String[] args 에 아무런 값도 입력되지 않은 상황이다.
		//자신이 입력해서 사용하는 경우에는 예외가 발생할 일이 없다.
		//사용자가 입력해서 사용하는 경우에는 문제가 발생할 가능성이 크다.
		//결국 RuntimeException 에 관련된 클래스의 예외처리 판단은 개발자가 하기 때문에
		//사용자에게 입력을 받는 경우 예외 처리 해줘야한다. (안할 경우에는 예외 메세지가 마음대로 출력한다)
		try {
			int korean = Integer.parseInt(args[0]);
			int english = Integer.parseInt(args[1]);
			double average = getAvg(korean,english);
			System.out.printf("평균 : %f", average);
		}catch(NumberFormatException e1) {
			//System.out.println("예외 메세지 : "+e1.getMessage()); //어떤 입력을 해서 예외가 발생했는지 알려준다.
			//e1.printStackTrace(); //JVM 이 뿌려주는 스택을 볼수 있다.
			//getMessage() 와 printStackTrace() 을 같이 쓰진 않는다.
			//보통 printStackTrace() 를 사용
			System.err.println("21억 이하의 정수를 입력하시오"); //out 을 err 로 바꾸면 빨간색으로 출력된다.
		}catch(ArrayIndexOutOfBoundsException e2) {
			System.err.println("두 개를 입력하시오");
		}finally {
			//예외 여부와 무관하게 무조건 실행되는 블럭
			//사용해도 되고 안해도 된다.
			System.out.println("finally");
		}
	}
}

