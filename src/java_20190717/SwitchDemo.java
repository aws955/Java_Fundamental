package java_20190717;

public class SwitchDemo {
	public static void main(String[] args) {
		int month = Integer.parseInt(args[0]);

		String season = "null";
		switch (month) {
		case 12:
		case 1:
		case 2:
			season = "겨울";
			break; // case 에 들어있는 값는 유일해야한다.
		case 3:
		case 4:
		case 5:
			season = "봄";
			break; // break가 없다면 case를 수행한 뒤에 switch 문을 빠져나오지못해서 밑의 케이스가 조건과 상관없이 수행된다.
		case 6:
		case 7:
		case 8:
			season = "여름"; 
			break; 
		case 9:
		case 10:
		case 11:
			season = "가을";
			break;
		default:
			season = "없는 계절";
		}
		System.out.printf("%d월은 %s입니다", month, season);
		System.out.printf("%d월은 %s입니다%n", month, season); // printf는 출력후 줄바꿈을 하지않는다. 줄바꿈을 하려면 %n을 해줘야한다.
		System.out.printf("%d월은 %s입니다%n", month, season);
		System.out.printf("%d월은 %s입니다%n", month, season);
	}

}
